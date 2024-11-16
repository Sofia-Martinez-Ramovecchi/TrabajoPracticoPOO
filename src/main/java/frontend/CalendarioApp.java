package frontend;

import calendario.Evento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class CalendarioApp {

    private JFrame frame;
    private JList<String> eventList;
    private DefaultListModel<String> eventListModel;
    private final List<Evento> eventos; // Lista de objetos Evento

    public CalendarioApp() {
        // Llamar al método que configura la interfaz y carga los eventos
        eventos = cargarEventos(); // Método ficticio para cargar eventos
        configurarInterfaz();
    }

    private void configurarInterfaz() {
        frame = new JFrame("Calendario de Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel para lista de eventos
        eventListModel = new DefaultListModel<>();
        cargarEventosEnLista();
        eventList = new JList<>(eventListModel);
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        eventList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic
                    mostrarDetalleEvento(eventList.getSelectedIndex());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(eventList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();
        JButton botonCrear = new JButton("Crear Evento");
        JButton botonEditar = new JButton("Editar Evento");
        JButton botonTodosEventos = new JButton("Todos los Eventos");

        // Acción al presionar "Crear Evento"
        botonCrear.addActionListener(e -> mostrarFormularioEvento(null));

        // Acción al presionar "Editar Evento"
        botonEditar.addActionListener(e -> {
            int index = eventList.getSelectedIndex();
            if (index != -1) {
                mostrarFormularioEvento(eventos.get(index));
            } else {
                JOptionPane.showMessageDialog(frame, "Selecciona un evento para editar.");
            }
        });

        // Acción al presionar "Todos los Eventos"
        botonTodosEventos.addActionListener(e -> mostrarTodosEventos());

        panelBotones.add(botonCrear);
        panelBotones.add(botonEditar);
        panelBotones.add(botonTodosEventos);

        frame.add(panelBotones, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void cargarEventosEnLista() {
    eventListModel.clear(); // Limpiar la lista
    Iterator<Evento> it = eventos.iterator();
    while (it.hasNext()) {
        Evento evento = it.next();
        if (evento.esProximo()) {
            eventListModel.addElement(evento.getFecha() + " - " + evento.getDescripcion());
        }
    }
}


    private void mostrarDetalleEvento(int index) {
        if (index >= 0) {
            Evento evento = eventos.get(index);
            JFrame detalleFrame = new JFrame("Detalle del Evento");
            detalleFrame.setSize(300, 200);
            detalleFrame.setLayout(new GridLayout(5, 1));

            detalleFrame.add(new JLabel("Nombre: " + evento.getNombre()));
            detalleFrame.add(new JLabel("Fecha: " + evento.getFecha()));
            detalleFrame.add(new JLabel("Ubicación: " + evento.getUbicacion()));
            detalleFrame.add(new JLabel("Descripción: " + evento.getDescripcion()));

            JButton botonAsignar = new JButton("Asignar Invitados");
            detalleFrame.add(botonAsignar);

            detalleFrame.setVisible(true);
        }
    }

   private void mostrarFormularioEvento(Evento evento) {
    JFrame formularioFrame = new JFrame(evento == null ? "Crear Evento" : "Editar Evento");
    formularioFrame.setSize(300, 250);
    formularioFrame.setLayout(new GridLayout(5, 2));

    JTextField nombreField = new JTextField(evento != null ? evento.getNombre() : "");
    JTextField fechaField = new JTextField(evento != null ? evento.getFecha().toString() : "");
    JTextField ubicacionField = new JTextField(evento != null ? evento.getUbicacion() : "");
    JTextField descripcionField = new JTextField(evento != null ? evento.getDescripcion() : "");

    formularioFrame.add(new JLabel("Nombre:"));
    formularioFrame.add(nombreField);
    formularioFrame.add(new JLabel("Fecha:"));
    formularioFrame.add(fechaField);
    formularioFrame.add(new JLabel("Ubicación:"));
    formularioFrame.add(ubicacionField);
    formularioFrame.add(new JLabel("Descripción:"));
    formularioFrame.add(descripcionField);

    JButton botonGuardar = new JButton("OK");
    botonGuardar.addActionListener(e -> {
        String nuevoNombre = nombreField.getText();
        String nuevaFecha = fechaField.getText();
        String nuevaUbicacion = ubicacionField.getText();
        String nuevaDescripcion = descripcionField.getText();

        if (evento != null) {
            // Editar evento existente
            evento.setNombre(nuevoNombre);
            evento.setFecha(nuevaFecha);
            evento.setUbicacion(nuevaUbicacion);
            evento.setDescripcion(nuevaDescripcion);
        } else {
            // Crear un nuevo evento y agregarlo a la lista
            Evento nuevoEvento = new Evento(nuevoNombre, nuevaFecha, nuevaUbicacion, nuevaDescripcion);
            eventos.add(nuevoEvento);
        }

        // Refrescar la lista de eventos en la interfaz
        cargarEventosEnLista();
        formularioFrame.dispose();
    });

    formularioFrame.add(new JButton("Cancelar"));
    formularioFrame.add(botonGuardar);

    formularioFrame.setVisible(true);
}


    private void mostrarTodosEventos() {
        JFrame todosFrame = new JFrame("Todos los Eventos");
        todosFrame.setSize(300, 400);
        DefaultListModel<String> todosModel = new DefaultListModel<>();
        eventos.forEach(e -> todosModel.addElement(e.getFecha() + " - " + e.getDescripcion()));
        JList<String> todosList = new JList<>(todosModel);
        todosFrame.add(new JScrollPane(todosList));
        todosFrame.setVisible(true);
    }

    private List<Evento> cargarEventos() {
        List<Evento> eventosCargados = new ArrayList<>();
        eventosCargados.add(new Evento("Evento 1", "15/11/2024 08:00", "Ubicación 1", "Descripción 1"));
        eventosCargados.add(new Evento("Evento 2", "15/11/2024 10:00", "Ubicación 2", "Descripción 2"));
        return eventosCargados;
    }
}
