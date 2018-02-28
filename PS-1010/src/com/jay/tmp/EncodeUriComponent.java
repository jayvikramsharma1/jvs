package com.jay.tmp;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class EncodeUriComponent {
	
	// Starting from https://sangupta.com/tech/encodeuricomponent-and.html
	public static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()";

		public static String encodeURIComponent2(String input, String charset)
		{
			if (input.isEmpty())
			{
				return input;
			}

			int l = input.length();
			StringBuilder o = new StringBuilder(l * 3);

			try
			{
				String e = "";

				for (int i = 0; i < l; i++)
				{
					e = input.substring(i, i + 1);

					if (ALLOWED_CHARS.indexOf(e) == -1)
					{
						byte[] b = e.getBytes(charset);
						o.append(getHex(b));
						continue;
					}

					o.append(e);
				}

				return o.toString();
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			return input;
		}

		private static String getHex(byte buf[])
		{
			StringBuilder o = new StringBuilder(buf.length * 3);
			int n = 0;

			for (int i = 0; i < buf.length; i++)
			{
				n = (int) buf[i] & 0xff;
				o.append("%");

				if (n < 0x10)
				{
					o.append("0");
				}

				o.append(Long.toString(n, 16).toUpperCase());
			}

			return o.toString();
		}
		
		public static void main(String[] args) {
			String encodedString  = encodeURIComponent2("+\"APR: 118144\"-exclusive:\"SundayTimesOnly\"", StandardCharsets.UTF_8.toString());
			System.out.println(encodedString);
		}

}
