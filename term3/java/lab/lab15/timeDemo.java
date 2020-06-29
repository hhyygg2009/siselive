package lab15;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
public class timeDemo extends TimerTask{
static Timer t;
static int num=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t=new Timer();
		long time=Integer.valueOf(javax.swing.JOptionPane.showInputDialog(null," ‰»Î∑÷÷”"));
		t.schedule(new timeDemo(),time*60*1000,60*1000);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(num>2||javax.swing.JOptionPane.showConfirmDialog(null, "ƒ÷÷”","",javax.swing.JOptionPane.YES_NO_OPTION)==javax.swing.JOptionPane.NO_OPTION) {
			t.cancel();
		}
		num++;
		
	}

}
