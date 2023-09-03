package cn.gary.JDBC;

import java.sql.*;

public class TextJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //使用jdbc访问数据库，完成数据维护
        //0:jdbc 初始化
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1。建立与数据库服务器连接的对象
        String dbUrl1="jdbc:mysql://127.0.0.1:3306/shoppingdb?useUnicode=yes&characterEncoding=utf-8";
        Connection connection= DriverManager.getConnection(dbUrl1,"root","1124");
        //向服务器下达命令（sql）
        String sql="select * from t_news_class";
        //String sql="insert into t_news_class(className) values('疫情新闻') ";
       //String sql="update t_news_class set className='新值' where classId=1";
        //String sql="delete  from t_news_class where classId=1 ";

       PreparedStatement statement= connection.prepareStatement(sql);
       //int result=statement.executeUpdate();
        ResultSet rs=statement.executeQuery();

        while (rs.next()){
            System.out.println("分类编号"+rs.getString("classid"));
            System.out.println("分类名称"+rs.getString(2));
        }
       //3.回收资源
        connection.close();



    }
}
