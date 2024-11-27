package ma.fpl.livreursvc.config;


import lombok.AllArgsConstructor;
import ma.fpl.livreursvc.web.LivreurSOAPController;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ClientSoapConfig {

    private Bus bus;
    private LivreurSOAPController livreurSOAPController;


    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, livreurSOAPController);
        endpoint.publish("/LivreurService");
        return endpoint;
    }
}