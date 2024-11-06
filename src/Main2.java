import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Main2 {
    public static void main(String[] args) {
        try {
            // Full path to the MySQL executable
            String mysqlPath = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe"; // Change path as necessary

            // Command to run
            String[] command = {mysqlPath, "-u", "root", "-p"};

            // Start the process
            Process process = Runtime.getRuntime().exec(command);

            // Send the password to the process
            try (OutputStream outputStream = process.getOutputStream()) {
                String password = "douaeBAKKALIensias1\n"; // Use \n for newline
                outputStream.write(password.getBytes());
                outputStream.flush();
            }

            // Reading the output from the command line
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Output the MySQL monitor prompt and other messages
            }
            // Wait for the process to finish
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
