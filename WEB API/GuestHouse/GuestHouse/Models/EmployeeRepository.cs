using GuestHouse.HelperClasses;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace GuestHouse.Models
{
    public class EmployeeRepository : IEmployeeRepository
    {
        private List<Employee> employee = new List<Employee>();
        SqlConnection dbConnection;



        public IEnumerable<Employee> GetAll()
        {
           
            SqlDataReader reader = null;

            dbConnection = DBConnect.getConnection();

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "Select * from tblEmployee ";
            sqlCmd.Connection = dbConnection;
            reader = sqlCmd.ExecuteReader();
            Employee emp = null;
            while (reader.Read())
            {
                emp = new Employee();
                emp.EmployeeId = Convert.ToInt32(reader.GetValue(0));
                emp.Name = reader.GetValue(1).ToString();
                emp.ManagerId = Convert.ToInt32(reader.GetValue(2));

                employee.Add(emp);
            }

            dbConnection.Close();
            
            return employee;
            
        }

        public Employee Get(int id)
        {
            SqlDataReader reader = null;

            dbConnection = DBConnect.getConnection();

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }
            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "Select * from tblEmployee where EmployeeId=" + id + "";
            sqlCmd.Connection = dbConnection;
            reader = sqlCmd.ExecuteReader();
            Employee emp = null;
            while (reader.Read())
            {
                emp = new Employee();
                emp.EmployeeId = Convert.ToInt32(reader.GetValue(0));
                emp.Name = reader.GetValue(1).ToString();
                emp.ManagerId = Convert.ToInt32(reader.GetValue(2));

            }

            dbConnection.Close();

            return emp;
        }

        public void PostEmployee(Employee employee) 
        {
            SqlDataReader reader = null;

            dbConnection = DBConnect.getConnection();

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "INSERT INTO tblEmployee (EmployeeId,Name,ManagerId) Values (@EmployeeId,@Name,@ManagerId)";
            sqlCmd.Connection = dbConnection;


            sqlCmd.Parameters.AddWithValue("@EmployeeId", employee.EmployeeId);
            sqlCmd.Parameters.AddWithValue("@Name", employee.Name);
            sqlCmd.Parameters.AddWithValue("@ManagerId", employee.ManagerId);
          
            int rowInserted = sqlCmd.ExecuteNonQuery();


            dbConnection.Close();
            
        }

        public void DeleteEmployee(int id)
        {
            SqlDataReader reader = null;

            dbConnection = DBConnect.getConnection();

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "delete from tblEmployee where EmployeeId=" + id + "";
            sqlCmd.Connection = dbConnection;
            int rowDeleted = sqlCmd.ExecuteNonQuery();
            dbConnection.Close();



        }
    }
}