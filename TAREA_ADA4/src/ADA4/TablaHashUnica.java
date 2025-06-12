/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADA4;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class TablaHashUnica extends JFrame {
    private JTextField tfCodigo, tfNombre, tfApellido, tfBuscarNombre, tfBuscarApellido;
    private JTextArea resultado;
    private Cliente[] tablaLineal;
    private TreeMap<String, Cliente>[] tablaArbol;
    private final int SIZE = 2000;
    private long tiempoInsercionLineal = 0, tiempoInsercionArbol = 0;

    public TablaHashUnica() {
        setTitle("Comparación de Métodos de Tabla Hash");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tablaLineal = new Cliente[SIZE];
        tablaArbol = new TreeMap[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tablaArbol[i] = new TreeMap<>();
        }

        JPanel panelEntrada = new JPanel(new GridLayout(7, 2));
        tfCodigo = new JTextField();
        tfNombre = new JTextField();
        tfApellido = new JTextField();
        tfBuscarNombre = new JTextField();
        tfBuscarApellido = new JTextField();

        panelEntrada.add(new JLabel("Código:"));
        panelEntrada.add(tfCodigo);
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(tfNombre);
        panelEntrada.add(new JLabel("Apellido:"));
        panelEntrada.add(tfApellido);

        panelEntrada.add(new JLabel("Nombre a buscar:"));
        panelEntrada.add(tfBuscarNombre);
        panelEntrada.add(new JLabel("Apellido a buscar:"));
        panelEntrada.add(tfBuscarApellido);

        JButton btnInsertar = new JButton("Insertar Cliente");
        JButton btnBuscar = new JButton("Buscar Cliente");
        JButton btnComplejidad = new JButton("Ver Comparación de Métodos");

        panelEntrada.add(btnInsertar);
        panelEntrada.add(btnBuscar);
        panelEntrada.add(btnComplejidad);

        add(panelEntrada, BorderLayout.NORTH);

        resultado = new JTextArea();
        resultado.setEditable(false);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        btnInsertar.addActionListener((ActionEvent e) -> {
            Cliente c = new Cliente(tfCodigo.getText(), tfNombre.getText(), tfApellido.getText());

            long start1 = System.nanoTime();
            insertarLineal(c);
            tiempoInsercionLineal += System.nanoTime() - start1;

            long start2 = System.nanoTime();
            insertarArbol(c);
            tiempoInsercionArbol += System.nanoTime() - start2;

            resultado.append("Insertado cliente: " + c.codigo + "\n");
        });

        btnBuscar.addActionListener((ActionEvent e) -> {
            String clave = tfBuscarNombre.getText() + tfBuscarApellido.getText();
            Cliente cl = buscarLineal(clave);
            Cliente ca = buscarArbol(clave);

            resultado.append("\nResultado de búsqueda:\n");
            resultado.append("Lineal: " + (cl != null ? cl.codigo : "No encontrado") + "\n");
            resultado.append("Árbol: " + (ca != null ? ca.codigo : "No encontrado") + "\n\n");
            mostrarGrafico();
        });

        btnComplejidad.addActionListener((ActionEvent e) -> {
            mostrarGraficoComparativo();
        });

        JTextArea analisis = new JTextArea();
        analisis.setText("\nNotación Asintótica:\n"
            + "Reasignación Lineal: Promedio O(1), Peor caso O(n)\n"
            + "Encadenamiento con Árbol: Promedio O(log n), Peor caso O(n)\n");
        analisis.setEditable(false);
        add(analisis, BorderLayout.SOUTH);
    }

    private void insertarLineal(Cliente cliente) {
        int index = hash(cliente.getClave());
        while (tablaLineal[index] != null) {
            index = (index + 1) % SIZE;
        }
        tablaLineal[index] = cliente;
    }

    private Cliente buscarLineal(String clave) {
        int index = hash(clave);
        int start = index;
        while (tablaLineal[index] != null) {
            if (tablaLineal[index].getClave().equals(clave)) {
                return tablaLineal[index];
            }
            index = (index + 1) % SIZE;
            if (index == start) break;
        }
        return null;
    }

    private void insertarArbol(Cliente cliente) {
        int index = hash(cliente.getClave());
        tablaArbol[index].put(cliente.getClave(), cliente);
    }

    private Cliente buscarArbol(String clave) {
        int index = hash(clave);
        return tablaArbol[index].get(clave);
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % SIZE;
    }

    private void mostrarGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(tiempoInsercionLineal / 1_000_000.0, "Reasignación Lineal", "Reasignación Lineal");
        dataset.addValue(tiempoInsercionArbol / 1_000_000.0, "Encadenamiento Árbol", "Encadenamiento Árbol");

        JFreeChart chart = ChartFactory.createBarChart(
            "Tiempos de Inserción",
            "Método",
            "Tiempo (ms)",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        plot.setRenderer(renderer);

        JFrame frame = new JFrame("Gráfica de Comparación");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setVisible(true);
    }

    private void mostrarGraficoComparativo() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int n = 1; n <= 12; n++) {
            dataset.addValue(n, "Reasignación Lineal O(n)", Integer.toString(n));
            dataset.addValue(Math.log(n), "Encadenamiento Árbol O(log n)", Integer.toString(n));
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Comparación de Complejidades",
            "n",
            "Tiempo relativo",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        plot.setRenderer(renderer);

        JFrame frame = new JFrame("Gráfico de Complejidades");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TablaHashUnica().setVisible(true));
    }

    class Cliente {
        public String codigo, nombre, apellido;

        public Cliente(String codigo, String nombre, String apellido) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getClave() {
            return nombre + apellido;
        }
    }
}
