package net.runelite.client.plugins.DeadZoneAPI;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.NonNull;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Singleton
public class MenuEntrySwapHandler
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuEntrySwapHandler.class);
	private static final Set<Integer> INTEGER_SET = Set.of(11927560);

	private final ArrayBlockingQueue<MenuEntry> entriesQueue = new ArrayBlockingQueue<>(50, true);
	private final ArrayBlockingQueue<enum2> entryTypeQueue = new ArrayBlockingQueue<>(50, true);

	private final Client client;
	private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, new DiscardPolicy());

	public MenuEntrySwapConsumer AB1CaddDEdaHI12361JKLM8NO3ka5gw;

	private int cdefghi367869abcdefhJKL1234AB1Cad;

	@Inject
	private MenuEntrySwapHandler(final Client client, final ConfigManager configManager)
	{
		this.client = client;
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw = new MenuEntrySwapConsumer(this.entriesQueue, this.entryTypeQueue, client, configManager);
		this.scheduledThreadPoolExecutor.submit(this.AB1CaddDEdaHI12361JKLM8NO3ka5gw);
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(@NonNull final MenuEntry entry, final int delay)
	{
		if (entry == null)
		{
			throw new NullPointerException("entry is marked non-null but is null");
		}
		else
		{
			try
			{
				final int parent = entry.getParam1() >> 16;
				if (entry.getParam1() > 0 && parent > 0 && !INTEGER_SET.contains(entry.getParam1()))
				{
					final int child = entry.getParam1() & 32767;
					final Widget widget = this.client.getWidget(parent, child);
					LOGGER.debug("|{}| Parent: {}, Child: {}", entry.getParam1(), parent, child);
					if (widget == null)
					{
						LOGGER.error("|{}| Parent: {}, Child: {}, was null.", entry.getParam1(), parent, child);
						return;
					}
				}
			}
			catch (final Exception var6)
			{
				LOGGER.info("Failed to add menu entry!");
				var6.printStackTrace();
				return;
			}

			this.scheduledThreadPoolExecutor.schedule(() -> {
				try
				{
					if (!this.entriesQueue.isEmpty())
					{
						LOGGER.info("Consumer hasn't finished yet! Preventing submission...");
						++this.cdefghi367869abcdefhJKL1234AB1Cad;
						if (this.cdefghi367869abcdefhJKL1234AB1Cad >= 5)
						{
							LOGGER.info("Flushing consumer queue!");
							this.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
							this.cdefghi367869abcdefhJKL1234AB1Cad = 0;
						}

						return;
					}

					this.entriesQueue.put(entry);
				}
				catch (final Exception var2)
				{
					var2.printStackTrace();
				}

			}, delay, TimeUnit.MILLISECONDS);
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(@NonNull final MenuEntry entry)
	{
		if (entry == null)
		{
			throw new NullPointerException("entry is marked non-null but is null");
		}
		else
		{
			try
			{
				final int parent = entry.getParam1() >> 16;
				if (entry.getParam1() > 0 && parent > 0 && !INTEGER_SET.contains(entry.getParam1()))
				{
					final int child = entry.getParam1() & 32767;
					final Widget widget = this.client.getWidget(parent, child);
					LOGGER.debug("|{}| Parent: {}, Child: {}", entry.getParam1(), parent, child);
					if (widget == null)
					{
						LOGGER.error("|{}| Parent: {}, Child: {}, was null.", entry.getParam1(), parent, child);
						return;
					}
				}
			}
			catch (final Exception var5)
			{
				LOGGER.info("Failed to add menu entry!");
				var5.printStackTrace();
				return;
			}

			this.scheduledThreadPoolExecutor.submit(() -> {
				try
				{
					if (!this.entriesQueue.isEmpty())
					{
						LOGGER.info("Consumer hasn't finished yet! Preventing submission...");
						++this.cdefghi367869abcdefhJKL1234AB1Cad;
						if (this.cdefghi367869abcdefhJKL1234AB1Cad >= 3)
						{
							LOGGER.info("Flushing consumer queue!");
							this.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						}

						return;
					}

					this.entriesQueue.put(entry);
				}
				catch (final Exception var2)
				{
					LOGGER.info("Failed to add new menu entry entry!");
					var2.printStackTrace();
				}

			});
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(@NonNull final MenuEntry entry, final enum2 type)
	{
		if (entry == null)
		{
			throw new NullPointerException("entry is marked non-null but is null");
		}
		else
		{
			try
			{
				final int parent = entry.getParam1() >> 16;
				if (entry.getParam1() > 0 && parent > 0 && !INTEGER_SET.contains(entry.getParam1()))
				{
					final int child = entry.getParam1() & 32767;
					final Widget widget = this.client.getWidget(parent, child);
					LOGGER.debug("|{}| Parent: {}, Child: {}", entry.getParam1(), parent, child);
					if (widget == null)
					{
						LOGGER.error("|{}| Parent: {}, Child: {}, was null.", entry.getParam1(), parent, child);
						return;
					}
				}
			}
			catch (final Exception var6)
			{
				LOGGER.info("Failed to add menu entry!");
				var6.printStackTrace();
				return;
			}

			this.scheduledThreadPoolExecutor.submit(() -> {
				try
				{
					if (!this.entriesQueue.isEmpty())
					{
						LOGGER.info("Consumer hasn't finished yet! Preventing submission...");
						++this.cdefghi367869abcdefhJKL1234AB1Cad;
						if (this.cdefghi367869abcdefhJKL1234AB1Cad >= 3)
						{
							LOGGER.info("Flushing consumer queue!");
							this.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						}

						return;
					}

					this.entriesQueue.put(entry);
					this.entryTypeQueue.put(type);
				}
				catch (final Exception var3)
				{
					LOGGER.info("Failed to add new menu entry entry!");
					var3.printStackTrace();
				}

			});
		}
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final List<MenuEntry> entries)
	{
		if (!entries.isEmpty())
		{
			label38:
			{
				final Exception var10000;
				label37:
				{
					final Iterator<MenuEntry> var2;
					try
					{
						var2 = entries.iterator();
					}
					catch (final Exception var8)
					{
						var10000 = var8;
						break label37;
					}

					while (true)
					{
						try
						{
							if (!var2.hasNext())
							{
								break label38;
							}

							final MenuEntry entry;
							final int parent = (entry = var2.next()).getParam1() >> 16;
							if (entry.getParam1() > 0 && parent > 0 && !INTEGER_SET.contains(entry.getParam1()))
							{
								final int child = entry.getParam1() & 32767;
								final Widget widget = this.client.getWidget(parent, child);
								LOGGER.debug("|{}| Parent: {}, Child: {}", entry.getParam1(), parent, child);
								if (widget == null)
								{
									LOGGER.error("|{}| Parent: {}, Child: {}, was null.", entry.getParam1(), parent, child);
									return;
								}
							}
						}
						catch (final Exception var7)
						{
							var10000 = var7;
							break;
						}
					}
				}

				final Exception e = var10000;
				LOGGER.info("Failed to add menu entry!");
				e.printStackTrace();
				return;
			}

			this.scheduledThreadPoolExecutor.submit(() -> {
				try
				{
					this.entriesQueue.addAll(entries);
				}
				catch (final Exception var2)
				{
					var2.printStackTrace();
				}
			});
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw.AB1CaddDEdaHI12361JKLM8NO3ka5gw((MenuEntry) null);
		this.entriesQueue.clear();
		this.entryTypeQueue.clear();
		this.client.setMenuEntries(new MenuEntry[0]);
		this.client.setMenuOptionCount(this.client.getMenuOptionCount());
		this.cdefghi367869abcdefhJKL1234AB1Cad = 0;
	}

	public enum enum2
	{
		INVENTORY,
		BANK
	}
}
