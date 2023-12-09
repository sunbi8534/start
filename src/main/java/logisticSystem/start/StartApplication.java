package logisticSystem.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import logistic.BackEnd;
import logistic.MainFrame;

@Service
@SpringBootApplication
@ComponentScan(basePackages = {"logistic", "logisticSystem.start"})
public class StartApplication extends MainFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StartApplication(BackEnd backEnd)
	{
		super(backEnd);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(StartApplication.class, args);
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mf = apc.getBean(StartApplication.class);
			        mf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}
}

