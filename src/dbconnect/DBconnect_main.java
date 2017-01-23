package dbconnect;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class DBconnect_main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		int id, year,ton;
		String name;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		DefaultCategoryDataset data = new DefaultCategoryDataset();

		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				year = rs.getInt("year");
				ton = rs.getInt("ton");
				System.out.println("ID：" + id);
				System.out.println("name：" + name);
				System.out.println("year：" + year);
				System.out.println("ton：" + ton);
				data.addValue(ton, name, String.valueOf(year));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //try catchで囲む
		
		Graph_view graph = new Graph_view(data);
		graph.setBounds(5,5,655,455);
		graph.setVisible(true);
	}
	

}
