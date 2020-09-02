package net.runelite.client.plugins.DeadZoneHunter;

import java.time.Instant;
import net.runelite.api.Tile;

public final class DZHunterAction
{
	final Instant startingTime;
	final Type type;
	final Tile itemTile;
	int jkld2369IJgha561gkkbcFdaw1fa5def;

	DZHunterAction(final Instant startingTime, final Type type, final Tile itemTile)
	{
		this.startingTime = startingTime;
		this.type = type;
		this.itemTile = itemTile;
	}

	public enum Type
	{
		Success,
		Collapsed,
		Failed;
	}
}
