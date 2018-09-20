package com.view;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PerformerView extends JFrame implements ActionListener{

	public final static String CREATE="Create state machine";
	public final static String LOAD="Load file";
	public final static String ABOUT="About program";
	public final static Font DEFAULT_FONT = new Font("Serif", Font.CENTER_BASELINE, 12);

	private JPanel contentPane;
	private static PerformerView performerView;
	
	public static void main(String[] args) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			PerformerView frame = PerformerView.getInstance();
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private PerformerView() {
		ViewFactory.createDefaultFrame(this);
		contentPane = (JPanel) this.getContentPane();
		setResizable(false);
		createPaneButtons();

	}
	public static PerformerView getInstance() {
		if(performerView ==null) {
			performerView = new PerformerView();
		}
		return performerView;
	}

	private void createPaneButtons() {
		contentPane.setLayout(null);
		ButtonPanel createMachine = new ButtonPanel();
		createMachine.setBounds(38, 40, 151, 109);
		createMachine.setBackground(ViewFactory.ButtonPaneBackgorund);
		createMachine.setCommand(CREATE);
		createMachine.setMessage(CREATE);
		contentPane.add(createMachine);
		
		ButtonPanel instructions = new ButtonPanel();
		instructions.setBounds(175, 169, 151, 109);
		instructions.setBackground(ViewFactory.ButtonPaneBackgorund);
		instructions.setCommand(ABOUT);
		instructions.setMessage(ABOUT);
		contentPane.add(instructions);
		
		ButtonPanel loadFile = new ButtonPanel();
		loadFile.setBounds(307, 40, 151, 109);
		loadFile.setBackground(ViewFactory.ButtonPaneBackgorund);
		loadFile.setCommand(LOAD);
		loadFile.setMessage(LOAD);

		contentPane.add(loadFile);
		addListeners(createMachine,loadFile,instructions);
		addFontToAll(DEFAULT_FONT,createMachine,loadFile,instructions);
	}

	private void addFontToAll(Font font, JPanel...panels) {
		for(JPanel panel : panels) {
			panel.setFont(font);
		}
		
	}

	private void addListeners(ButtonPanel... panels) {
		for(ButtonPanel panel : panels) {
			panel.addContainerListener(this);
		}
		
	}

	@Override
	public void dispose() {
		super.dispose();
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(CREATE)) {
			showCreateMachine();
		}else if(command.equals(LOAD)) {
			loadFile();
		}else if(command.equals(ABOUT)) {
			showAboutPane();
		}
	}

	private void showAboutPane() {
		// TODO Auto-generated method stub
		
	}

	private void loadFile() {		
		//TODO
	}

	private void showCreateMachine() {
		MainView.getInstance().setVisible(true);
		this.setExtendedState(ICONIFIED);
	}

	
}