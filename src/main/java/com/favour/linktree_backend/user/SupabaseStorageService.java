package com.favour.linktree_backend.user;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SupabaseStorageService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.key}")
    private String supabaseKey;

    @Value("${supabase.bucket}")
    private String bucketName;

    private final OkHttpClient client = new OkHttpClient();

    public String uploadFile(byte[] fileBytes, String fileName, String contentType) throws IOException {
        RequestBody requestBody = RequestBody.create(fileBytes, MediaType.parse(contentType));

        Request request = new Request.Builder()
                .url(supabaseUrl + "/storage/v1/object/" + bucketName + "/" + fileName)
                .header("Authorization", "Bearer " + supabaseKey)
                .header("Content-Type", contentType)
                .put(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Upload failed: " + response);
            }

            // Construct the public URL manually
            return supabaseUrl + "/storage/v1/object/public/" + bucketName + "/" + fileName;
        }
    }
}
