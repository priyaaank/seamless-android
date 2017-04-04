package seamless.com.seamless.domain.sync;

public interface SyncAdapter {

	void upload(ManagedFile managedFile);

	ManagedFile download();

	void listing();

}
