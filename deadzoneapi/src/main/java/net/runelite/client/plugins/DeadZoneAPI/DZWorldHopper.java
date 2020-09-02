package net.runelite.client.plugins.DeadZoneAPI;

import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.WorldService;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldRegion;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;

public class DZWorldHopper
{
	@Inject
	private final Client client;
	@Inject
	private final WorldService worldService;

	public DZWorldHopper(final Client client, final WorldService worldService)
	{
		this.client = client;
		this.worldService = worldService;
	}

	public final World AB1CaddDEdaHI12361JKLM8NO3ka5gw(final WorldType type, final WorldRegion region)
	{
		try
		{
			final WorldResult result = worldService.getWorlds();

			if (result == null)
			{
				return null;
			}

			final World currentWorld = result.findWorld(client.getWorld());

			final List<World> worlds = result.getWorlds();

			Collections.shuffle(worlds);

			for (World world : worlds)
			{
				if (world.getRegion() == region && world.getPlayers() <= 1000 && currentWorld.getId() != world.getId())
				{
					boolean validWorld = true;

					if (world.getTypes().size() > 0)
					{
						if (!world.getTypes().contains(type) || world.getTypes().contains(WorldType.LEAGUE) || world.getTypes().contains(WorldType.HIGH_RISK) || world.getTypes().contains(WorldType.PVP) || world.getTypes().contains(WorldType.SKILL_TOTAL) || world.getTypes().contains(WorldType.TOURNAMENT) || world.getTypes().contains(WorldType.DEADMAN))
						{
							validWorld = false;
						}
					}
					else
					{
						validWorld = false;
					}
					if (validWorld)
					{
						return world;
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		System.out.println("Failed to get optimal world!");

		return null;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final World world)
	{
		if (client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) == null)
		{
			client.openWorldHopper();
			return;
		}
		final net.runelite.api.World rsWorld;
		(rsWorld = client.createWorld()).setActivity(world.getActivity());
		rsWorld.setAddress(world.getAddress());
		rsWorld.setId(world.getId());
		rsWorld.setPlayerCount(world.getPlayers());
		rsWorld.setLocation(world.getLocation());
		rsWorld.setTypes(WorldUtil.toWorldTypes(world.getTypes()));
		client.hopToWorld(rsWorld);
	}
}

