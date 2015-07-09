using GuestHouse.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace GuestHouse.Controllers
{
    public class EmployeeController : ApiController
    {
        static readonly IEmployeeRepository repository = new EmployeeRepository();

        #region  Explecitl called functions inside the controller
        /*
         *Explicitly called functions inside the controller  
         *         [HttpGet]
        [ActionName("GetEmployeeByID")]
        public Employee Get(int id)
        {
            //return listEmp.First(e => e.ID == id);
            SqlDataReader reader = null;
            SqlConnection myConnection = new SqlConnection();
            myConnection.ConnectionString = @"Server=.\SQLSERVER2008R2;Database=DBCompany;User ID=sa;Password=Tpg@1234;";

            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "Select * from tblEmployee where EmployeeId=" + id + "";
            sqlCmd.Connection = myConnection;
            myConnection.Open();
            reader = sqlCmd.ExecuteReader();
            Employee emp = null;
            while (reader.Read())
            {
                emp = new Employee();
                emp.EmployeeId = Convert.ToInt32(reader.GetValue(0));
                emp.Name = reader.GetValue(1).ToString();
                emp.ManagerId = Convert.ToInt32(reader.GetValue(2));
            }
            return emp;
            myConnection.Close();
        }


        [HttpPost]
        public void AddEmployee(Employee employee)
        {
            //int maxId = listEmp.Max(e => e.ID);
            //employee.ID = maxId + 1;
            //listEmp.Add(employee);


            SqlConnection myConnection = new SqlConnection();
            myConnection.ConnectionString = @"Server=.\SQLSERVER2008R2;Database=DBCompany;User ID=sa;Password=Tpg@1234;";
            //SqlCommand sqlCmd = new SqlCommand("INSERT INTO tblEmployee (EmployeeId,Name,ManagerId) Values (@EmployeeId,@Name,@ManagerId)", myConnection);
            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "INSERT INTO tblEmployee (EmployeeId,Name,ManagerId) Values (@EmployeeId,@Name,@ManagerId)";
            sqlCmd.Connection = myConnection;


            sqlCmd.Parameters.AddWithValue("@EmployeeId", employee.EmployeeId);
            sqlCmd.Parameters.AddWithValue("@Name", employee.Name);
            sqlCmd.Parameters.AddWithValue("@ManagerId", employee.ManagerId);
            myConnection.Open();
            int rowInserted = sqlCmd.ExecuteNonQuery();
            myConnection.Close();
        }


        [ActionName("DeleteEmployee")]
        public void DeleteEmployeeByID(int id)
        {
            SqlConnection myConnection = new SqlConnection();
            myConnection.ConnectionString = @"Server=.\SQLSERVER2008R2;Database=DBCompany;User ID=sa;Password=Tpg@1234;";
            // myConnection.ConnectionString = @"Server=NDI-LAP-274\SQLSERVER2008R2;Database=DBCompany;Trusted_Connection=True;";
            SqlCommand sqlCmd = new SqlCommand();
            sqlCmd.CommandType = CommandType.Text;
            sqlCmd.CommandText = "delete from tblEmployee where EmployeeId=" + id + "";
            sqlCmd.Connection = myConnection;
            myConnection.Open();
            int rowDeleted = sqlCmd.ExecuteNonQuery();
            myConnection.Close();
        }
         */
        #endregion

        // Getting all the employees from list
        public IEnumerable<Employee> GetAllEmployees()    
        {
            return repository.GetAll();
        }

        //Getting the employees by ID
        public Employee Get(int id)
        {
            return repository.Get(id); 
        }

        //Add Employee
        // Content-Type: application/json use this to send an object using fiddler
        //Format of the JSON Object {"EmployeeId":23,"Name":"Mac Miller","ManagerId":34}
        public String PostEmployee(Employee emp)
        {
            repository.PostEmployee(emp);
            return "Success";
        }


        public String DeleteEmployee(int id)
        {
            repository.DeleteEmployee(id);
            return "Deleted";
        }

        //Adding Two Paarameters
        // [Route("api/YOURCONTROLLER/{paramOne}/{paramTwo}")]
    }


}
