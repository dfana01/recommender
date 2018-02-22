import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class hadoopconnection {

	public static OutputStream getFile(String file) throws IOException {
		
		String url = "hdfs://10.0.2.15:9000/user/hduser/files/" + file;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(url), conf);
		
		InputStream in = null;
		
		in = fs.open(new Path(url));
		
		
		try
		{
			OutputStream readfile = null;
			IOUtils.copyBytes(in, n, 6144, false);
		} 
		finally 
		{
			IOUtils.closeStream(in);
		}
		
		return readfile;
	}
}