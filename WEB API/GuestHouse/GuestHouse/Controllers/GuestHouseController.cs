using GuestHouse.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace GuestHouse.Controllers
{
    public class GuestHouseController : ApiController
    {
        //
        // GET: /GuestHouse/
        static readonly IGuestHouseRepository repository = new GuestHouseRepository();
        //Getting the GuestHouse details By ID
        public DataSet Get(int id)
        {
            return repository.Get(id);
        }
    }
}
