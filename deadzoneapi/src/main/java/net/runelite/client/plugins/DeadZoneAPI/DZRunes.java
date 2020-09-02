package net.runelite.client.plugins.DeadZoneAPI;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.awt.image.BufferedImage;
import java.util.Map;

@SuppressWarnings("unused")
public enum DZRunes
{
	AIR(1, 556),
	WATER(2, 555),
	EARTH(3, 557),
	FIRE(4, 554),
	MIND(5, 558),
	CHAOS(6, 562),
	DEATH(7, 560),
	BLOOD(8, 565),
	COSMIC(9, 564),
	NATURE(10, 561),
	LAW(11, 563),
	BODY(12, 559),
	SOUL(13, 566),
	ASTRAL(14, 9075),
	MIST(15, 4695),
	MUD(16, 4698),
	DUST(17, 4696),
	LAVA(18, 4699),
	STEAM(19, 4694),
	SMOKE(20, 4697),
	WRATH(21, 21880);

	private final int id;
	private final int itemId;
	private BufferedImage bufferedImage;
	private static final Map<Integer, DZRunes> map;

	DZRunes(final int id, final int itemId)
	{
		this.id = id;
		this.itemId = itemId;
	}

	public static DZRunes AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int varbit)
	{
		return map.get(varbit);
	}

	public String DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		final String name;
		final String var10000 = (name = this.name()).substring(0, 1);
		return var10000 + name.substring(1).toLowerCase();
	}

	public final int AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return this.id;
	}

	public int JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		return this.itemId;
	}

	public BufferedImage jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		return this.bufferedImage;
	}

	public void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final BufferedImage image)
	{
		this.bufferedImage = image;
	}

	static
	{
		final Builder<Integer, DZRunes> builder = new ImmutableMap.Builder<>();

		for (final DZRunes runes : values())
		{
			builder.put(runes.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), runes);
		}

		map = builder.build();
	}
}
