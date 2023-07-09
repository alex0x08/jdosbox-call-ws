import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.Activity;

public class TestWS {

    public static void main(String[] args) throws ApiException {




        ApiClient c = new ApiClient();
        c.setScheme("https");
        c.setHost("www.boredapi.com");

        DefaultApi d = new DefaultApi(c);

        Activity a=  d.activityGet();

        System.out.println("a: "+a.getActivity());


    }
}
