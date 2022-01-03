package vue.menu;

public class Score extends Menu {
	
	/**
	 * Constructeur par défaut de la classe Score
	 */
	public Score() {
		// Appel au constructeur de la super classe Menu
		super();
		// TODO Auto-generated constructor stub
		
		/**
		// Partie affichage
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
	
			CustomBtn btnQuitterScore = new CustomBtn("Retour");
			lsCustomBtn.add(btnQuitterScore);
			btnQuitterScore.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent evt) {
					cmdQuitterScore();
				}
			});
		JPanel btnPanel = new JPanel(new GridBagLayout());
		btnPanel.setOpaque(false);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 0, 30, 0);
		btnPanel.add(btnQuitterScore, gbc);
		**/
	}
	
	////////////////////////////////////////
	//           COMMANDES LIEES          //
	//             AUX BOUTTONS           //        
	////////////////////////////////////////
	
	/**
	 * Demande de changement de menu : Retour vers l'ancien menu
	 */
	/**
	private void cmdQuitterScore() {
		ControleurGeneral.ctrlBouton.rqtRetour();
	}
	*/

}
