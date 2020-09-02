package net.runelite.client.plugins.DeadZoneAPI;

import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DZRetrySystem
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZRetrySystem.class);

	@Inject
	private final Client client;

	public String AB1CaddDEdaHI12361JKLM8NO3ka5gw;

	private boolean jkld2369IJgha561gkkbcFdaw1fa5def;

	private int PQRS23TgasdUVWX114666ce13Abefgh93f9awdf;
	private int asgn2kd1p2no455mnop2dqrstuvwxyz111146;
	private int jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq;
	private int cdefghi367869abcdefhJKL1234AB1Cad;
	private int vwxyzQdw3RSTUVwxyz11114XYZ1234;
	private int s6641asgn2kd1dasgha1333;

	public DZRetrySystem(final Client client, final String header)
	{
		this.client = client;
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw = header;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int maxFake, final int maxMinors, final int maxMajors)
	{
		this.asgn2kd1p2no455mnop2dqrstuvwxyz111146 = maxFake;
		this.cdefghi367869abcdefhJKL1234AB1Cad = maxMinors;
		this.s6641asgn2kd1dasgha1333 = maxMajors;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf = 0;
		this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq = 0;
		this.vwxyzQdw3RSTUVwxyz11114XYZ1234 = 0;
		this.jkld2369IJgha561gkkbcFdaw1fa5def = false;
	}

	public final boolean DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return this.jkld2369IJgha561gkkbcFdaw1fa5def;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final String reason)
	{
		if (this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf + 1 >= this.asgn2kd1p2no455mnop2dqrstuvwxyz111146)
		{
			this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf = 0;
			this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(reason);
		}
		else
		{
			++this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf;
		}
	}

	public final void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf = 0;
	}

	private void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final String reason)
	{
		if (this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq + 1 >= this.cdefghi367869abcdefhJKL1234AB1Cad)
		{
			this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq = 0;
			this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2(reason);
		}
		else
		{
			LOGGER.info("Minor Failure Reported! Reason: " + reason);
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.AB1CaddDEdaHI12361JKLM8NO3ka5gw + "Minor Failure Detected!", null);
			++this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq;
		}
	}

	private void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2(final String reason)
	{
		if (this.vwxyzQdw3RSTUVwxyz11114XYZ1234 + 1 >= this.s6641asgn2kd1dasgha1333)
		{
			LOGGER.info("Encountered too many failures! Reason: " + reason);
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.AB1CaddDEdaHI12361JKLM8NO3ka5gw + "Encountered too many failures, shutting down!", null);
			this.jkld2369IJgha561gkkbcFdaw1fa5def = true;
		}
		else
		{
			++this.vwxyzQdw3RSTUVwxyz11114XYZ1234;
			LOGGER.info("Major Failure Detected! Reason: " + reason);
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.AB1CaddDEdaHI12361JKLM8NO3ka5gw + "Major Failure Detected!", null);
		}
	}
}
