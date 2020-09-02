package net.runelite.client.plugins.DeadZoneAgility;

import java.util.LinkedList;
import java.util.List;
import javax.inject.Singleton;

@Singleton
final class DZAgilityCourseManager
{
	private int DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
	private int JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2;
	private final List<Integer> jkld2369IJgha561gkkbcFdaw1fa5def = new LinkedList<>();

	final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final DZAgilityCourse newStep)
	{
		this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178 = newStep.getSteps() - 1;
		this.jkld2369IJgha561gkkbcFdaw1fa5def.clear();
		final int[] newStep1 = newStep.getObjs();

		for (final int i : newStep1)
		{
			this.jkld2369IJgha561gkkbcFdaw1fa5def.add(i);
		}

	}

	final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		if (this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 + 1 > this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178)
		{
			System.out.println("Reached end of course, resetting!");
			this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 = 0;
		}
		else
		{
			++this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2;
		}
	}

	final void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 = 0;
	}

	final int JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		return this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2;
	}

	final int jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		return this.jkld2369IJgha561gkkbcFdaw1fa5def.get(this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2);
	}
}
