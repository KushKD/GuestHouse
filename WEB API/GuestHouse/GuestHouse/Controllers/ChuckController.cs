using GuestHouse.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace GuestHouse.Controllers
{
    public class ChuckController : ApiController
    {
        private static List<ChuckFact> facts = new List<ChuckFact>()
    {
        new ChuckFact { Id = 1, Rating = 4, 
            Text = "Chuck Norris doesn't call the wrong number. You answer the wrong phone." },
        new ChuckFact { Id = 2, Rating = 3, 
            Text = "Chuck Norris counted to infinity. Twice." },
        new ChuckFact { Id = 3, Rating = 4, 
            Text = "When Alexander Bell invented the telephone he had 3 missed calls from Chuck Norris." }
    };

        public IEnumerable<ChuckFact> GetAllFacts()
        {
            return facts;
        }

        public ChuckFact GetFactByID(int id)
        {
            ChuckFact fact = (from f in facts where f.Id == id select f).FirstOrDefault();
            if (fact == null)
                throw new HttpResponseException(this.Request.CreateResponse(HttpStatusCode.NotFound));

            return fact;
        }

        public HttpResponseMessage PostFact(ChuckFact fact)
        {
            if (!this.ModelState.IsValid)
                throw new HttpResponseException(Request.CreateResponse(HttpStatusCode.BadRequest));

            facts.Add(fact);
            HttpResponseMessage response = this.Request.CreateResponse(HttpStatusCode.Created, fact);
            response.Headers.Location = new Uri(Url.Link("DefaultApi", "Success"));

            return response;
        }
    }


}
