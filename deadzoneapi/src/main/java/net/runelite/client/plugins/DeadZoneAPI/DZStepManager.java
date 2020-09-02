package net.runelite.client.plugins.DeadZoneAPI;

@SuppressWarnings("unused")
public final class DZStepManager
{
	private int totalSteps;
	private int currentStep;

	public DZStepManager(final int totalSteps)
	{
		this.totalSteps = totalSteps;
	}

	private void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final int totalSteps)
	{
		this.totalSteps = totalSteps;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int newStep)
	{
		this.currentStep = newStep;
		if (this.currentStep > this.totalSteps)
		{
			this.currentStep = 0;
		}

	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		if (this.currentStep + 1 > this.totalSteps)
		{
			this.currentStep = 0;
		}
		else
		{
			++this.currentStep;
		}
	}

	public final void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		--this.currentStep;
		if (this.currentStep < 0)
		{
			this.currentStep = 0;
		}

	}

	public final void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		this.currentStep = 0;
	}

	public final int jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		return this.currentStep;
	}

	private int PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		return this.totalSteps;
	}
}
