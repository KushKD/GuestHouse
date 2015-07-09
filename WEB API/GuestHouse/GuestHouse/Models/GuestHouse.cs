using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GuestHouse.Models
{
    public class GuestHouse
    {

        // Eight Properties 
       public string RoomNo { get; set; }
       public string FloorEntrance { get; set; }
       public string Orientation { get; set; }
       public string Type_of_Room { get; set; }
       public string Bath_Facility { get; set; }
       public string TV_Facility { get; set; }
       public string Room_Condition { get; set; }
       public int Bed_Capacity { get; set; }

    }
}