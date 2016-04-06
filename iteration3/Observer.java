package systemAnalysis;

import java.io.IOException;

public interface Observer {

	public void Update(Product p) throws IOException;
}
