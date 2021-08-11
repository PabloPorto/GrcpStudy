import com.yrrhelp.grcp.User;
import com.yrrhelp.grcp.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("ball").setPassword("Any").build();
        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());
    }
}
