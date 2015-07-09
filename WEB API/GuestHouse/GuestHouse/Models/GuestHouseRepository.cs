using GuestHouse.HelperClasses;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace GuestHouse.Models
{
    public class GuestHouseRepository : IGuestHouseRepository
    {

        SqlConnection dbConnection;  

        public DataSet Get(int id)
        {
            SqlDataReader reader = null;

            dbConnection = DBConnect.getConnection();

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }
            DataSet dt = new DataSet(); 
            SqlCommand cmd = new SqlCommand("USP_Fetch_HostelRoomMaster", dbConnection);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@TypeId", id);

            SqlDataAdapter adp = new SqlDataAdapter(cmd);
            try
            {
                adp.Fill(dt);
            }
            catch
            { 

            }
            finally
            { 
                adp.Dispose();
            }

            return dt; 
        }
    }
}