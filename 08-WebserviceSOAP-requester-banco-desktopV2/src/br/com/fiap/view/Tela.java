package br.com.fiap.view;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Pesquisar;
import br.com.fiap.bo.TimeBOStub.PesquisarResponse;
import br.com.fiap.bo.TimeBOStub.Time;
import org.eclipse.swt.custom.SashForm;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtTitulos;
	private Text txtTurma;
	private Text txtCodigoBusca;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(20, 23, 55, 15);
		lblNome.setText("Nome");

		Label lblTtulos = new Label(shell, SWT.NONE);
		lblTtulos.setBounds(20, 71, 55, 15);
		lblTtulos.setText("T\u00EDtulos");

		Label lblTurma = new Label(shell, SWT.NONE);
		lblTurma.setBounds(20, 119, 55, 15);
		lblTurma.setText("Turma");

		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(20, 44, 198, 21);

		txtTitulos = new Text(shell, SWT.BORDER);
		txtTitulos.setBounds(20, 92, 198, 21);

		txtTurma = new Text(shell, SWT.BORDER);
		txtTurma.setBounds(20, 140, 198, 21);

		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recupera a informação da tela
				String nome = txtNome.getText();
				String turma = txtTurma.getText();
				String titulos = txtTitulos.getText();
				try {
					//Instanciar um time
					Time time = new Time();
					time.setNome(nome);
					time.setTurma(turma);
					time.setTitulos(Integer.parseInt(titulos));
					//Instanciar um Stub
					TimeBOStub bo = new TimeBOStub();
					//Intanciar o "Cadastar"
					Cadastrar entity = new Cadastrar();
					//Setar o time no "Cadastrar"
					entity.setTime(time);
					//Chamar o método do stub passando o "Cadastar"
					bo.cadastrar(entity);
					//Exibir a mensagem de sucesso
					MessageBox dialog = new MessageBox(shell,SWT.OK);
					dialog.setMessage("Time "+nome+" cadastrado!" );
					dialog.open();//Exibe o dialog
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(20, 191, 198, 25);
		btnCadastrar.setText("Cadastrar");

		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(224, 23, 26, 196);

		Label lblBuscar = new Label(shell, SWT.NONE);
		lblBuscar.setBounds(257, 23, 108, 15);
		lblBuscar.setText("Buscar por c\u00F3digo");

		txtCodigoBusca = new Text(shell, SWT.BORDER);
		txtCodigoBusca.setBounds(257, 44, 88, 21);

		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				int codigo = Integer.parseInt(txtCodigoBusca.getText());
				try {
					//Instanciar um Stub
					TimeBOStub bo = new TimeBOStub();
					//Chamar a classe pesquisar
					Pesquisar entity = new Pesquisar();
					entity.setCodigo(codigo);

					//Atribuir a response o resultado da pesquisa
					PesquisarResponse response = bo.pesquisar(entity);
					//Renderizar o response para retorno e colocar em um objeto
					Time time = response.get_return();

					//Messege box
					MessageBox dialog = new MessageBox(shell,SWT.OK);
					dialog.setMessage("Resultado:"
							+ "\n Nome: " + time.getNome()
							+ "\n Titulos: " + time.getTitulos()
							+ "\n Turma: " + time.getTurma());
					dialog.open();//Exibe o dialog

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(369, 44, 55, 21);
		btnBuscar.setText("Buscar");

	}
}
