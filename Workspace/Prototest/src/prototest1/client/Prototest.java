package prototest1.client;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.awt.Color;
import java.util.Date;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.core.client.EntryPoint;
import java.util.ArrayList;
import com.google.gwt.dev.asm.Label;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;

public class Prototest implements EntryPoint{

	private static final int REFRESH_INTERVAL = 5000; // ms
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Button addStockButton = new Button("Add");
	private ArrayList<String> stocks = new ArrayList<String>();
	private Button[][] buttons = new Button[10][10];
	private Button lastUpdatedLabel = new Button();
	private int getCollumn=0;
	private String text = new String("o");

	
	
	  /**
	   * Entry point method.
	   */
	public void onModuleLoad() {
	    // Create table for stock data.
		for(int i = 0;i<10; i++)
			{	//stocksFlexTable.insertRow(i);
				for(int j=0; j<10;j++){
				buttons[i][j]=new Button("x");
				stocksFlexTable.setWidget(i, j, buttons[i][j]);
				buttons[i][j].addClickHandler(new ClickHandler()
				{
					public void onClick(ClickEvent e) 
					{
						 for(int i=0;i<10;i++)
					        {
					            for(int j=0;j<10;j++)
					            {
					                if (e.getSource().equals(buttons[i][j]))
					                {
					                    doTheClick(i,j);
					                    
					                }
					            }
					        }
						
					}
					
				
				});
				
				}
			}
		
		
		
	    
		  mainPanel.add(stocksFlexTable);
		  mainPanel.add(addPanel);
		  
		  RootPanel.get().add(mainPanel);
	   ;
		  
		
		  
		
		  
	  }
	
	

	  

  
	 
	 
	
	
	private void doTheClick(int posx, int posy)
	
	{	
		for(int i=0;i<10;i++)
			for(int j =0;j<10;j++)
				buttons[i][j].setText("x");
		//Window.alert(String.valueOf(posx)+""+String.valueOf(posy));
		if(buttons[posx][posy].getText()=="o")
			{text= "x";}
		else
			{text="o";}
			
		for(int i = 0; i<10;i++)
			{buttons[i][posy].setText(text);
			//Thread.sleep(100);
			
			}
		for(int j = 0; j<10;j++)
			{buttons[posx][j].setText(text);
			
			
				//Thread.sleep(100);
			
			}
		
	}
	
	
}