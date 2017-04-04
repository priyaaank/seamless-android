package seamless.com.seamless.domain.sync.s3;

import android.content.Context;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3Client;

import seamless.com.seamless.domain.sync.ManagedFile;
import seamless.com.seamless.domain.sync.SyncAdapter;


public class S3SyncAdapter implements SyncAdapter {

	private final TransferUtility transferUtility;
	private final AmazonS3Client amazonS3Client;

	public S3SyncAdapter(AWSCredentials credentialsProvider, Context applicationContext) {
		this.amazonS3Client = new AmazonS3Client(credentialsProvider);
		this.transferUtility = new TransferUtility(amazonS3Client, applicationContext);
	}

	@Override
	public void upload(ManagedFile file) {

	}

	@Override
	public ManagedFile download() {
		return null;
	}

	@Override
	public void listing() {

	}

}
