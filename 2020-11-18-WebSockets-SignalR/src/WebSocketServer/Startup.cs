using System;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.DependencyInjection;
using WebSocketServer.Middleware;


namespace WebSocketServer
{
    public class Startup
    {
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddWebSocketManager();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            // To Define a WebSockets we have to define our middlewares
            app.UseWebSockets();

            app.UseWebSocketServer();

            app.Run(async context =>
            {
                Console.WriteLine("3rd delegate request");
                await context.Response.WriteAsync("3rd delegate requrest.");
            });

        }
    }
}
