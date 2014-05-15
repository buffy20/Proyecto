/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.awt.Frame;
import java.awt.Image;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lou
 */
public class Panel extends javax.swing.JPanel {

    private Pelicula pelicula;
    private Actor actor;
    private Director director;
    private Genero genero;
    private NumberFormat formatoEuro = NumberFormat.getCurrencyInstance();

    public Panel() {
        initComponents();
        //documentCharactersLimiter1.setLimit(10);
    }
    
    public Director getDirector(){
        return director;
    }
    
    public Actor getActor(){
        return actor;
    }
    
    public Genero getGenero(){
        return genero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void showData() {
        actor = pelicula.getIdActor();
        director = pelicula.getIdDirector();
        jTextFiledTitulo.setText(pelicula.getTitulo());
        jTextFieldProductora.setText(pelicula.getProductora());
        jTextFieldNacionalidad.setText(pelicula.getNacionalidad());
        jDateChooser1.setDate(pelicula.getFechaEstreno());
        jTextFieldDuracion.setText(String.valueOf(pelicula.getDuracion()));
        jTextFieldRecaudacion.setText(formatoEuro.format(pelicula.getRecaudacion()));
        if (pelicula.getIdGenero() == null) {
            jComboBoxGenero.setSelectedIndex(0);
        } else {
            jComboBoxGenero.setSelectedIndex(pelicula.getIdGenero().getIdGenero());
        }
        if (director == null) {
            jTextFieldDirector.setText("");
        } else {
            jTextFieldDirector.setText(pelicula.getIdDirector().getNombre() + " " + pelicula.getIdDirector().getApellidos());
        }
        if (actor == null) {
            jTextFieldActor.setText("");
        } else {
            jTextFieldActor.setText(pelicula.getIdActor().getNombre() + " " + pelicula.getIdActor().getApellidos());
        }
        if (pelicula.getRutaImagen().isEmpty()) {
            imagen.setIcon(new ImageIcon(getClass().getResource("")));
        } else {
            imagen.setIcon(new ImageIcon(getClass().getResource(pelicula.getRutaImagen())));
        }
        if (pelicula.getOscars()) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }
        this.showValoracion();
    }

    public void clear() {
        jTextFiledTitulo.setText("");
        jTextFieldProductora.setText("");
        jTextFieldNacionalidad.setText("");
        jDateChooser1.setDate(null);
        jTextFieldDuracion.setText("");
        jTextFieldRecaudacion.setText("");
        jCheckBox1.setVisible(true);
        jSlider1.setValue(0);
        jComboBoxGenero.setSelectedIndex(0);
        jTextFieldDirector.setText("");
        jTextFieldActor.setText("");
        imagen.setIcon(new ImageIcon(getClass().getResource("")));
        pelicula.setValoracion(0);
        this.showValoracion();
    }

    public Pelicula getData() {
        //Pelicula pelicula = new Pelicula();
        String title = jTextFiledTitulo.getText();
        try {
            if (title != null) {

                pelicula.setTitulo(title);
                pelicula.setProductora(jTextFieldProductora.getText());
                pelicula.setNacionalidad(jTextFieldNacionalidad.getText());
                pelicula.setDuracion(Short.valueOf(jTextFieldDuracion.getText()));
                pelicula.setRecaudacion(BigInteger.valueOf(Long.valueOf(jTextFieldRecaudacion.getText())));
                pelicula.setFechaEstreno(jDateChooser1.getDate());
                pelicula.setValoracion(jSlider1.getValue());
                //Genero ver = (Genero) genero.getSelectedItem();
                pelicula.setIdGenero(null);
                pelicula.setIdDirector(director);
                pelicula.setIdActor(actor);
                //pelicula.setRutaImagen(null);
                if (jCheckBox1.isSelected()) {
                    pelicula.setOscars(true);
                } else {
                    pelicula.setOscars(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe rellenar el campo Título", "Información", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return pelicula;
    }

    public Pelicula update() {
        String title = jTextFiledTitulo.getText();
        try {
            if (title != null) {
                pelicula.setTitulo(title);
                pelicula.setProductora(jTextFieldProductora.getText());
                pelicula.setNacionalidad(jTextFieldNacionalidad.getText());
                pelicula.setDuracion(Short.valueOf(jTextFieldDuracion.getText()));
                pelicula.setRecaudacion(BigInteger.valueOf(Long.valueOf(jTextFieldRecaudacion.getText())));
                pelicula.setFechaEstreno(jDateChooser1.getDate());
                pelicula.setValoracion(jSlider1.getValue());
                //Genero ver = (Genero) genero.getSelectedItem();
                pelicula.setIdGenero(null);
                pelicula.setIdDirector(null);
                pelicula.setIdActor(null);
                //pelicula.setRutaImagen(null);
                if (jCheckBox1.isSelected()) {
                    pelicula.setOscars(true);
                } else {
                    pelicula.setOscars(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe rellenar el campo Título", "Información", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return pelicula;
    }

    public void showValoracion() {
        switch (pelicula.getValoracion()) {
            case 0:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/0stars.png")));
                break;
            case 1:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/1star.png")));
                break;
            case 2:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/2stars.png")));
                break;
            case 3:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/3stars.png")));
                break;
            case 4:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/4stars.png")));
                break;
            case 5:
                estrellas.setIcon(new ImageIcon(getClass().getResource("/resources/5stars.png")));
                break;
        }
    }

    public void editable(boolean si) {
        if (si) {
            jTextFieldProductora.setEditable(true);
            jComboBoxGenero.setEnabled(true);
            jTextFieldDirector.setEditable(true);
            jTextFiledTitulo.setEditable(true);
            jTextFieldNacionalidad.setEditable(true);
            jTextFieldRecaudacion.setEditable(true);
            jTextFieldActor.setEditable(true);
            jTextFieldDuracion.setEditable(true);
            jDateChooser1.setEnabled(true);
            jCheckBox1.setEnabled(true);
            jSlider1.setVisible(true);
            botonDirector.setVisible(true);
            botonActor.setVisible(true);
            examinar.setVisible(true);
            image.setVisible(true);
        } else {
            jTextFieldProductora.setEditable(false);
            jComboBoxGenero.setEnabled(false);
            jTextFieldDirector.setEditable(false);
            jTextFiledTitulo.setEditable(false);
            jTextFieldNacionalidad.setEditable(false);
            jTextFieldRecaudacion.setEditable(false);
            jTextFieldActor.setEditable(false);
            jTextFieldDuracion.setEditable(false);
            jDateChooser1.setEnabled(false);
            jCheckBox1.setEnabled(false);
            jSlider1.setVisible(false);
            botonDirector.setVisible(false);
            botonActor.setVisible(false);
            examinar.setVisible(false);
            image.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFiledTitulo = new javax.swing.JTextField();
        jTextFieldProductora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextFieldNacionalidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDuracion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDirector = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldActor = new javax.swing.JTextField();
        jTextFieldRecaudacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBoxGenero = new javax.swing.JComboBox();
        jSlider1 = new javax.swing.JSlider();
        estrellas = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        botonDirector = new javax.swing.JButton();
        botonActor = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        examinar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Título:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));
        jPanel1.add(jTextFiledTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, 250, -1));
        jPanel1.add(jTextFieldProductora, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 49, 250, -1));

        jLabel2.setText("Productora:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        jLabel3.setText("Fecha de estreno:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 80, 214, -1));
        jPanel1.add(jTextFieldNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 120, 190, -1));

        jLabel4.setText("Nacionalidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, -1, -1));

        jLabel5.setText("Duración:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, -1, -1));

        jTextFieldDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDuracionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 158, 190, -1));

        jLabel9.setText("Género:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, -1, -1));
        jPanel1.add(jTextFieldDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 234, 190, -1));

        jLabel10.setText("Director:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 237, -1, -1));

        jLabel11.setText("Actor Principal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 271, -1, -1));
        jPanel1.add(jTextFieldActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 268, 190, -1));
        jPanel1.add(jTextFieldRecaudacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 190, -1));

        jLabel6.setText("Recaudación:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel7.setText("Óscars:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel8.setText("Valoración:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 376, -1, -1));

        jCheckBox1.setOpaque(false);
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 331, -1, 20));

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin Categoría", "Romance", "Drama", "Ciencia Ficción", "Bélico", "Animación", "Thriller", "Comedia", "Terror", "Biográfica", "Fantasía", "Musical", "Acción" }));
        jComboBoxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jSlider1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(5);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setOpaque(false);
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 240, -1));
        jPanel1.add(estrellas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 240, 40));
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 301, 446));

        botonDirector.setText("Ver");
        botonDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDirectorActionPerformed(evt);
            }
        });
        jPanel1.add(botonDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 50, -1));

        botonActor.setText("Ver");
        botonActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActorActionPerformed(evt);
            }
        });
        jPanel1.add(botonActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        image.setForeground(new java.awt.Color(255, 255, 255));
        image.setText("Imagen:");
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));

        examinar.setText("Examinar");
        examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarActionPerformed(evt);
            }
        });
        jPanel1.add(examinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cinema.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDuracionActionPerformed

    private void jComboBoxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGeneroActionPerformed

    private void botonDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDirectorActionPerformed
        jTextFieldDirector.setText("");
        Frame frameParent = Frame.getFrames()[0];
        ListaDirectores dialogListaDirectores = new ListaDirectores(frameParent, true);
        dialogListaDirectores.setVisible(true);
        director = dialogListaDirectores.getDirectorSelected();
        jTextFieldDirector.setText(director.getNombre() + " " + director.getApellidos());
    }//GEN-LAST:event_botonDirectorActionPerformed

    private void botonActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActorActionPerformed
        jTextFieldDirector.setText("");
        Frame frameParent = Frame.getFrames()[0];
        ListaActores dialogListaActores = new ListaActores(frameParent, true);
        dialogListaActores.setVisible(true);
        actor = dialogListaActores.getActorSelected();
        jTextFieldActor.setText(actor.getNombre() + " " + actor.getApellidos());
    }//GEN-LAST:event_botonActorActionPerformed

    private void examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes", "bmp", "gif", "jpg", "png");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ImageIcon photo = new ImageIcon(fileChooser.getSelectedFile().getPath());
            if (photo.getIconHeight() > 342 || photo.getIconWidth() > 230) {
                ImageIcon photoDimension = new ImageIcon(photo.getImage().getScaledInstance(301, 446, Image.SCALE_SMOOTH));
                imagen.setIcon(photoDimension);
            } else {
                imagen.setIcon(photo);
            }
        }
        //Guardar la ruta de la imagen en la película
        pelicula.setRutaImagen(fileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_examinarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActor;
    private javax.swing.JButton botonDirector;
    private javax.swing.JLabel estrellas;
    private javax.swing.JButton examinar;
    private javax.swing.JLabel image;
    private javax.swing.JLabel imagen;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxGenero;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldActor;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldDuracion;
    private javax.swing.JTextField jTextFieldNacionalidad;
    private javax.swing.JTextField jTextFieldProductora;
    private javax.swing.JTextField jTextFieldRecaudacion;
    private javax.swing.JTextField jTextFiledTitulo;
    // End of variables declaration//GEN-END:variables
}
