package contoh.modul.retrofitsample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//https://www.googleapis.com/blogger/v3/blogs/6793974253482588684/posts?labels=Menghilangkan%20Ketombe&key=AIzaSyC92QnTp-w7zHsguF4ZIn3xXYVDftFF_pc

public interface NetworkEndpoint {
    @GET("{id}/posts/")
    Call<Response> getDataBlog(@Path("id") String id,
                                 @Query("labels") String label,
                                 @Query("key") String apiKey,
                                 @Query("pageToken") String nextPageToken);
}
