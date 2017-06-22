import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Run {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();		
		WebTarget webTarget = client.target("http://localhost:8080/HelloJersey/hello");
		
		Invocation.Builder invocationBuilder = webTarget.request();
		
		for (int i = 1; i <= 10; i++)
		{
			invocationBuilder.post(Entity.entity("hello " + i, MediaType.TEXT_PLAIN));
		}		
		
		Invocation.Builder invocationBuilder2 = webTarget.request();
		Response response = invocationBuilder2.get();	
		
		String msg = response.readEntity(String.class);
		System.out.println("Message from server: " + msg);	

	}

}
