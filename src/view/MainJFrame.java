package view;

import execucao.Compilador;
import execucao.EsquemaTraducao;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import lib.NumberedBorder;

/**
 * @author Francisco Lucas Sens
 * @author Karin Cristiane Corrêa
 * @author William Lopes da Silva
 */
public class MainJFrame extends javax.swing.JFrame {

    private final Compilador compilador;
    private final Clipboard clipboard;
    private final TransferHandler transferHandler;
    private String caminhoArquivo;
    private final FileNameExtensionFilter fileNameExtensionFilter;
    private static EsquemaTraducao esquemaTraducao;

    public MainJFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            initComponents();
            jMenuBar.setBackground(Color.decode("#2B2B2B"));
            jToolBar.setBackground(Color.decode("#2B2B2B"));
            super.getContentPane().setBackground(Color.decode("#2B2B2B"));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextAreaEditor.setTabSize(4);
        compilador = new Compilador();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        transferHandler = jTextAreaEditor.getTransferHandler();
        caminhoArquivo = "";
        fileNameExtensionFilter = new FileNameExtensionFilter("Documento de Texto (*.txt)", "txt");
        esquemaTraducao = new EsquemaTraducao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemCutJPopupMenu = new javax.swing.JMenuItem();
        jMenuItemCopyJPopupMenu = new javax.swing.JMenuItem();
        jMenuItemPasteJPopupMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCompileJPopupMenu = new javax.swing.JMenuItem();
        jToolBar = new javax.swing.JToolBar();
        jButtonNewJMenuBar = new javax.swing.JButton();
        jButtonOpenJMenuBar = new javax.swing.JButton();
        jButtonSaveJMenuBar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonCopyJMenuBar = new javax.swing.JButton();
        jButtonCutJMenuBar = new javax.swing.JButton();
        jButtonPasteJMenuBar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonCompileJMenuBar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButtonAboutJMenuBar = new javax.swing.JButton();
        jPanelBarraStatus = new javax.swing.JPanel();
        jLabelCaminhoArquivo = new javax.swing.JLabel();
        jScrollPaneEditor = new javax.swing.JScrollPane();
        jTextAreaEditor = new javax.swing.JTextArea();
        jScrollPaneOutput = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNewJMenuBar = new javax.swing.JMenuItem();
        jMenuItemOpenJMenuBar = new javax.swing.JMenuItem();
        jMenuItemSaveJMenuBar = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemCutJMenuBar = new javax.swing.JMenuItem();
        jMenuItemCopyJMenuBar = new javax.swing.JMenuItem();
        jMenuItemPasteJMenuBar = new javax.swing.JMenuItem();
        jMenuRun = new javax.swing.JMenu();
        jMenuItemCompileJMenuBar = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAboutJMenuBar = new javax.swing.JMenuItem();

        jMenuItemCutJPopupMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCutJPopupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/scissors_16x16.png"))); // NOI18N
        jMenuItemCutJPopupMenu.setText("Cut");
        jMenuItemCutJPopupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortar(evt);
            }
        });
        jPopupMenu.add(jMenuItemCutJPopupMenu);

        jMenuItemCopyJPopupMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCopyJPopupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/copy_16x16.png"))); // NOI18N
        jMenuItemCopyJPopupMenu.setText("Copy");
        jMenuItemCopyJPopupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiar(evt);
            }
        });
        jPopupMenu.add(jMenuItemCopyJPopupMenu);

        jMenuItemPasteJPopupMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPasteJPopupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/paste_16x16.png"))); // NOI18N
        jMenuItemPasteJPopupMenu.setText("Paste");
        jMenuItemPasteJPopupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colar(evt);
            }
        });
        jPopupMenu.add(jMenuItemPasteJPopupMenu);
        jPopupMenu.add(jSeparator3);

        jMenuItemCompileJPopupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/compile_16x16.png"))); // NOI18N
        jMenuItemCompileJPopupMenu.setText("Compile");
        jMenuItemCompileJPopupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilar(evt);
            }
        });
        jPopupMenu.add(jMenuItemCompileJPopupMenu);

        jPopupMenu.getAccessibleContext().setAccessibleDescription("");
        jPopupMenu.getAccessibleContext().setAccessibleParent(jTextAreaEditor);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nosso Compilador");
        setIconImage(new ImageIcon(MainJFrame.class.getResource("/resources/imagens/ladybug_16x16.png")).getImage());
        setMinimumSize(new java.awt.Dimension(900, 620));

        jToolBar.setBorder(null);
        jToolBar.setRollover(true);
        jToolBar.setBorderPainted(false);
        jToolBar.setFocusable(false);

        jButtonNewJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/file_24x24.png"))); // NOI18N
        jButtonNewJMenuBar.setToolTipText("New [ctrl - n]");
        jButtonNewJMenuBar.setBorderPainted(false);
        jButtonNewJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNewJMenuBar.setFocusable(false);
        jButtonNewJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNewJMenuBar.setOpaque(false);
        jButtonNewJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNewJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonNewJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novo(evt);
            }
        });
        jToolBar.add(jButtonNewJMenuBar);

        jButtonOpenJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/open_file_24x24.png"))); // NOI18N
        jButtonOpenJMenuBar.setToolTipText("Open [ctrl-o]");
        jButtonOpenJMenuBar.setBorderPainted(false);
        jButtonOpenJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOpenJMenuBar.setFocusable(false);
        jButtonOpenJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOpenJMenuBar.setOpaque(false);
        jButtonOpenJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOpenJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonOpenJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir(evt);
            }
        });
        jToolBar.add(jButtonOpenJMenuBar);

        jButtonSaveJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/diskette_24x24.png"))); // NOI18N
        jButtonSaveJMenuBar.setToolTipText("Save [ctrl - s]");
        jButtonSaveJMenuBar.setBorderPainted(false);
        jButtonSaveJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveJMenuBar.setFocusable(false);
        jButtonSaveJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveJMenuBar.setOpaque(false);
        jButtonSaveJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonSaveJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar(evt);
            }
        });
        jToolBar.add(jButtonSaveJMenuBar);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        jSeparator1.setSeparatorSize(new java.awt.Dimension(2, 30));
        jToolBar.add(jSeparator1);

        jButtonCopyJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/copy_24x24.png"))); // NOI18N
        jButtonCopyJMenuBar.setToolTipText("Copy [ctrl - c]");
        jButtonCopyJMenuBar.setBorderPainted(false);
        jButtonCopyJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCopyJMenuBar.setFocusable(false);
        jButtonCopyJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCopyJMenuBar.setOpaque(false);
        jButtonCopyJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCopyJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonCopyJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiar(evt);
            }
        });
        jToolBar.add(jButtonCopyJMenuBar);

        jButtonCutJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/scissors_24x24.png"))); // NOI18N
        jButtonCutJMenuBar.setToolTipText("Cut [ctrl - x]");
        jButtonCutJMenuBar.setBorderPainted(false);
        jButtonCutJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCutJMenuBar.setFocusable(false);
        jButtonCutJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCutJMenuBar.setOpaque(false);
        jButtonCutJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCutJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonCutJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortar(evt);
            }
        });
        jToolBar.add(jButtonCutJMenuBar);

        jButtonPasteJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/paste_24x24.png"))); // NOI18N
        jButtonPasteJMenuBar.setToolTipText("Paste [ctrl - v]");
        jButtonPasteJMenuBar.setBorderPainted(false);
        jButtonPasteJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPasteJMenuBar.setFocusable(false);
        jButtonPasteJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPasteJMenuBar.setOpaque(false);
        jButtonPasteJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPasteJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonPasteJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colar(evt);
            }
        });
        jToolBar.add(jButtonPasteJMenuBar);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        jSeparator2.setSeparatorSize(new java.awt.Dimension(2, 30));
        jToolBar.add(jSeparator2);

        jButtonCompileJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/compile_24x24.png"))); // NOI18N
        jButtonCompileJMenuBar.setToolTipText("Compile [F9]");
        jButtonCompileJMenuBar.setBorderPainted(false);
        jButtonCompileJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCompileJMenuBar.setFocusable(false);
        jButtonCompileJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCompileJMenuBar.setOpaque(false);
        jButtonCompileJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCompileJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonCompileJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilar(evt);
            }
        });
        jToolBar.add(jButtonCompileJMenuBar);

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOpaque(true);
        jSeparator4.setSeparatorSize(new java.awt.Dimension(2, 30));
        jToolBar.add(jSeparator4);

        jButtonAboutJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/about_24x24.png"))); // NOI18N
        jButtonAboutJMenuBar.setToolTipText("About  [F1]");
        jButtonAboutJMenuBar.setBorderPainted(false);
        jButtonAboutJMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAboutJMenuBar.setFocusable(false);
        jButtonAboutJMenuBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAboutJMenuBar.setOpaque(false);
        jButtonAboutJMenuBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAboutJMenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonMouseExited(evt);
            }
        });
        jButtonAboutJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobre(evt);
            }
        });
        jToolBar.add(jButtonAboutJMenuBar);

        jLabelCaminhoArquivo.setBackground(Color.decode("#323232"));
        jLabelCaminhoArquivo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabelCaminhoArquivo.setForeground(Color.decode("#619647"));
        jLabelCaminhoArquivo.setOpaque(true);

        javax.swing.GroupLayout jPanelBarraStatusLayout = new javax.swing.GroupLayout(jPanelBarraStatus);
        jPanelBarraStatus.setLayout(jPanelBarraStatusLayout);
        jPanelBarraStatusLayout.setHorizontalGroup(
            jPanelBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCaminhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelBarraStatusLayout.setVerticalGroup(
            jPanelBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCaminhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        jScrollPaneEditor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneEditor.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextAreaEditor.setBackground(Color.decode("#2B2B2B"));
        jTextAreaEditor.setColumns(20);
        jTextAreaEditor.setForeground(Color.decode("#A9B7C6"));
        jTextAreaEditor.setRows(5);
        jTextAreaEditor.setBorder(new NumberedBorder());
        jTextAreaEditor.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextAreaEditor.setComponentPopupMenu(jPopupMenu);
        jScrollPaneEditor.setViewportView(jTextAreaEditor);

        jScrollPaneOutput.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneOutput.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextAreaOutput.setEditable(false);
        jTextAreaOutput.setBackground(Color.decode("#2B2B2B"));
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setForeground(Color.decode("#A9B7C6"));
        jTextAreaOutput.setRows(5);
        jScrollPaneOutput.setViewportView(jTextAreaOutput);

        jMenuFile.setForeground(new java.awt.Color(255, 255, 255));
        jMenuFile.setText("File");

        jMenuItemNewJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNewJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemNewJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemNewJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/file_16x16.png"))); // NOI18N
        jMenuItemNewJMenuBar.setText("New");
        jMenuItemNewJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novo(evt);
            }
        });
        jMenuFile.add(jMenuItemNewJMenuBar);

        jMenuItemOpenJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemOpenJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemOpenJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/open_file_16x16.png"))); // NOI18N
        jMenuItemOpenJMenuBar.setText("Open");
        jMenuItemOpenJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenJMenuBar);

        jMenuItemSaveJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemSaveJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemSaveJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/diskette_16x16.png"))); // NOI18N
        jMenuItemSaveJMenuBar.setText("Save");
        jMenuItemSaveJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveJMenuBar);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setForeground(new java.awt.Color(255, 255, 255));
        jMenuEdit.setText("Edit");

        jMenuItemCutJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCutJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemCutJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemCutJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/scissors_16x16.png"))); // NOI18N
        jMenuItemCutJMenuBar.setText("Cut");
        jMenuItemCutJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortar(evt);
            }
        });
        jMenuEdit.add(jMenuItemCutJMenuBar);

        jMenuItemCopyJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCopyJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemCopyJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemCopyJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/copy_16x16.png"))); // NOI18N
        jMenuItemCopyJMenuBar.setText("Copy");
        jMenuItemCopyJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiar(evt);
            }
        });
        jMenuEdit.add(jMenuItemCopyJMenuBar);

        jMenuItemPasteJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPasteJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemPasteJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemPasteJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/paste_16x16.png"))); // NOI18N
        jMenuItemPasteJMenuBar.setText("Paste");
        jMenuItemPasteJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colar(evt);
            }
        });
        jMenuEdit.add(jMenuItemPasteJMenuBar);

        jMenuBar.add(jMenuEdit);

        jMenuRun.setForeground(new java.awt.Color(255, 255, 255));
        jMenuRun.setText("Run");

        jMenuItemCompileJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItemCompileJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemCompileJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemCompileJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/compile_16x16.png"))); // NOI18N
        jMenuItemCompileJMenuBar.setText("Compile");
        jMenuItemCompileJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilar(evt);
            }
        });
        jMenuRun.add(jMenuItemCompileJMenuBar);

        jMenuBar.add(jMenuRun);

        jMenuHelp.setForeground(new java.awt.Color(255, 255, 255));
        jMenuHelp.setText("Help");

        jMenuItemAboutJMenuBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAboutJMenuBar.setBackground(Color.decode("#2B2B2B")
        );
        jMenuItemAboutJMenuBar.setForeground(Color.decode("#A9B7C6"));
        jMenuItemAboutJMenuBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/about_16x16.png"))); // NOI18N
        jMenuItemAboutJMenuBar.setText("About");
        jMenuItemAboutJMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobre(evt);
            }
        });
        jMenuHelp.add(jMenuItemAboutJMenuBar);

        jMenuBar.add(jMenuHelp);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneEditor)
                    .addComponent(jPanelBarraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneOutput))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanelBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMouseEntered
        JButton jButton = (JButton) evt.getComponent();
        jButton.setBackground(Color.decode("#A9B7C6"));
        jButton.setOpaque(true);

    }//GEN-LAST:event_jButtonMouseEntered

    private void jButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMouseExited
        JButton jButton = (JButton) evt.getComponent();
        jButton.setOpaque(false);
    }//GEN-LAST:event_jButtonMouseExited

    private void compilar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilar
        esquemaTraducao.limparTudo();
        String retorno = compilador.compilar(jTextAreaEditor.getText());
        jTextAreaOutput.setText(retorno);
        if (retorno.equals(Compilador.STATUS_COMPILACAO)) {
            try {
                File file = new File(caminhoArquivo.replace("txt", "il"));
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(esquemaTraducao.obterCodigo());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {

            }
        }

    }//GEN-LAST:event_compilar

    private void novo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novo
        limparTudo();
    }//GEN-LAST:event_novo

    public static EsquemaTraducao getEsquemaTraducao() {
        return esquemaTraducao;
    }

    private void limparTudo() {
        caminhoArquivo = "";
        jTextAreaEditor.setText("");
        jTextAreaOutput.setText("");
        jLabelCaminhoArquivo.setText("");
    }

    private void abrir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + File.separator + "Desktop"));
        int open = jFileChooser.showOpenDialog(this);
        switch (open) {
            case APPROVE_OPTION:
                File arquivo = jFileChooser.getSelectedFile();
                caminhoArquivo = arquivo.getAbsolutePath();
                jLabelCaminhoArquivo.setText(caminhoArquivo);
                jTextAreaOutput.setText("");
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    bufferedReader.lines().forEach(line -> stringBuilder.append(line).append("\n"));
                    jTextAreaEditor.setText(stringBuilder.toString());
                    bufferedReader.close();
                } catch (IOException e) {
                    limparTudo();
                    caminhoArquivo = "";
                    JOptionPane.showMessageDialog(null, "Não foi possível abrir o seu arquivo", "Aviso", ERROR_MESSAGE);
                }
                break;
        }
    }//GEN-LAST:event_abrir

    private void cortar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortar
        transferHandler.exportToClipboard(jTextAreaEditor, clipboard, TransferHandler.MOVE);
    }//GEN-LAST:event_cortar

    private void copiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiar
        transferHandler.exportToClipboard(jTextAreaEditor, clipboard, TransferHandler.COPY);
    }//GEN-LAST:event_copiar

    private void colar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colar
        transferHandler.importData(jTextAreaEditor, clipboard.getContents(null));
    }//GEN-LAST:event_colar

    private void salvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar
        if (caminhoArquivo.isEmpty()) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.setFileFilter(fileNameExtensionFilter);
            int opcao = jFileChooser.showSaveDialog(this);
            if (opcao == APPROVE_OPTION) {
                caminhoArquivo = jFileChooser.getSelectedFile().getAbsolutePath();
                if (!caminhoArquivo.toLowerCase().endsWith(".txt")) {
                    caminhoArquivo += ".txt";
                }
                File arquivo = new File(caminhoArquivo);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo));
                    bufferedWriter.write(jTextAreaEditor.getText());
                    bufferedWriter.close();
                    jLabelCaminhoArquivo.setText(caminhoArquivo);
                    jTextAreaOutput.setText("Arquivo criado e salvo com sucesso");
                } catch (IOException ex) {
                    JOptionPane.showInputDialog(null, "Não foi possível salvar o seu arquivo");
                }
            }
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivo));
            bufferedWriter.write(jTextAreaEditor.getText());
            bufferedWriter.close();
            jTextAreaOutput.setText("Alterado com sucesso");
        } catch (IOException ex) {
            JOptionPane.showInputDialog(null, "Não foi possível salvar o seu arquivo");
        }
    }//GEN-LAST:event_salvar

    private void sobre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobre
        jTextAreaOutput.setText("Francisco Lucas Sens\nKarin Cristiane Corrêa\nWilliam Lopes da Silva");
    }//GEN-LAST:event_sobre

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAboutJMenuBar;
    private javax.swing.JButton jButtonCompileJMenuBar;
    private javax.swing.JButton jButtonCopyJMenuBar;
    private javax.swing.JButton jButtonCutJMenuBar;
    private javax.swing.JButton jButtonNewJMenuBar;
    private javax.swing.JButton jButtonOpenJMenuBar;
    private javax.swing.JButton jButtonPasteJMenuBar;
    private javax.swing.JButton jButtonSaveJMenuBar;
    private javax.swing.JLabel jLabelCaminhoArquivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAboutJMenuBar;
    private javax.swing.JMenuItem jMenuItemCompileJMenuBar;
    private javax.swing.JMenuItem jMenuItemCompileJPopupMenu;
    private javax.swing.JMenuItem jMenuItemCopyJMenuBar;
    private javax.swing.JMenuItem jMenuItemCopyJPopupMenu;
    private javax.swing.JMenuItem jMenuItemCutJMenuBar;
    private javax.swing.JMenuItem jMenuItemCutJPopupMenu;
    private javax.swing.JMenuItem jMenuItemNewJMenuBar;
    private javax.swing.JMenuItem jMenuItemOpenJMenuBar;
    private javax.swing.JMenuItem jMenuItemPasteJMenuBar;
    private javax.swing.JMenuItem jMenuItemPasteJPopupMenu;
    private javax.swing.JMenuItem jMenuItemSaveJMenuBar;
    private javax.swing.JMenu jMenuRun;
    private javax.swing.JPanel jPanelBarraStatus;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPaneEditor;
    private javax.swing.JScrollPane jScrollPaneOutput;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTextArea jTextAreaEditor;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables

}
