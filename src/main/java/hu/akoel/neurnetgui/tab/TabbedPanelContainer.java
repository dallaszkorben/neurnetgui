package hu.akoel.neurnetgui.tab;

import hu.akoel.neurnet.handlers.DataHandler;
import hu.akoel.neurnet.network.Network;
import hu.akoel.neurnetgui.DataModel;
import hu.akoel.neurnetgui.accessories.Common;
import hu.akoel.neurnetgui.accessories.CompositeIcon;
import hu.akoel.neurnetgui.accessories.VTextIcon;

import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class TabbedPanelContainer extends JTabbedPane{

	private static final long serialVersionUID = -8066765323009172519L;

	private TrainingTab trainingTab;
	private ConstructionTab constructionTab;
	
	CompositeIcon trainingTabIcon;
	CompositeIcon constructionTabIcon;
	
	public TabbedPanelContainer( Network network, DataHandler trainingDataHandler, DataModel dataModel ){
		super(RIGHT);
		
		trainingTab = new TrainingTab(network, trainingDataHandler, dataModel);
		VTextIcon trainingTabTextIcon = new VTextIcon(trainingTab, Common.getTranslated("training.title"), VTextIcon.ROTATE_LEFT);
		Icon trainingTabGraphicIcon = UIManager.getIcon("FileView.computerIcon");
		trainingTabIcon = new CompositeIcon( trainingTabGraphicIcon, trainingTabTextIcon );

		constructionTab = new ConstructionTab();//network, trainingDataHandler, dataModel);
		VTextIcon constructionTabTextIcon = new VTextIcon(constructionTab, Common.getTranslated("construction.title"), VTextIcon.ROTATE_LEFT);
		Icon constructionTabGraphicIcon = UIManager.getIcon("FileView.computerIcon");
		constructionTabIcon = new CompositeIcon( constructionTabGraphicIcon, constructionTabTextIcon );


		this.addTab( null, trainingTabIcon, trainingTab );
		this.addTab( null, constructionTabIcon, constructionTab );

		this.setSelectedIndex( 0 );
	}
}
