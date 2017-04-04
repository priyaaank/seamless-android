package seamless.com.seamless.domain.sync.s3;

import com.amazonaws.auth.AWSCredentials;

public class UserAwsS3Credentials implements AWSCredentials {

	private final String key;
	private final String secret;

	public UserAwsS3Credentials(final String key, final String secret) {
		this.key = key;
		this.secret = secret;
	}

	@Override
	public String getAWSAccessKeyId() {
		return key;
	}

	@Override
	public String getAWSSecretKey() {
		return secret;
	}
}
