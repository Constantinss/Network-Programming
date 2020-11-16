using System;
using Microsoft.AspNetCore.SignalR;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace SignalRServer
{
    public class ChatHub: Hub
    {
        public override Task OnConnectedAsync()
        {
            System.Console.WriteLine("--> Connected...");
            Clients.Client(Context.ConnectionId).SendAsync("ReceivedConnId", Context.ConnectionId);
            return base.OnConnectedAsync();
        }

        public async Task SendMessageAsync(string message)
        {
            var routeObject = JsonConvert.DeserializeObject<dynamic>(message);
            string toClient = routeObject.To;
            System.Console.WriteLine("Message recieved on: " + Context.ConnectionId);

            if(toClient == string.Empty)
            {
                // broadcast message
                await Clients.All.SendAsync("ReceiveMessage", message);
            }
            else
            {
                await Clients.Client(toClient).SendAsync("ReceoveMessage", message);
            }
        }
    }
}