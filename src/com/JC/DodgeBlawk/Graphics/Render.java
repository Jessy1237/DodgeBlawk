package com.JC.DodgeBlawk.Graphics;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Play;
import com.JC.DodgeBlawk.Entities.Asteroid;
import com.JC.DodgeBlawk.Entities.Blawk;
import com.JC.DodgeBlawk.Entities.Bullet;
import com.JC.DodgeBlawk.Entities.Entity;
import com.JC.DodgeBlawk.Entities.Player;
import com.JC.DodgeBlawk.Entities.PowerUp;
import com.JC.DodgeBlawk.Management.Collision;
import com.JC.DodgeBlawk.Management.Power;
import com.JC.DodgeBlawk.Management.PowerChecker;
import com.JC.DodgeBlawk.Management.Score;
import com.JC.DodgeBlawk.Util.Animations;
import com.JC.DodgeBlawk.Util.Generation;
import com.JC.DodgeBlawk.Util.LoadEntities;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Render {

	public static boolean ShowInformation = false;
	public static boolean HyperSpaceMode = false;

	// Render order: top left, top right, bottom right, bottom left.
	public void fixPlayerPosition(Player p, GameContainer gc) {
		if (p.getLocation().getX() < 0)
			p.getLocation().setX(0);
		if (p.getLocation().getX() > gc.getWidth() - p.getSize().getWidth())
			p.getLocation().setX(gc.getWidth() - p.getSize().getWidth());
		if (p.getLocation().getY() < 0)
			p.getLocation().setY(0);
		if (p.getLocation().getY() > gc.getHeight() - p.getSize().getHeight() - 65)
			p.getLocation().setY(gc.getHeight() - p.getSize().getHeight() - 65);
	}

	@SuppressWarnings({ "static-access" })
	public Render(Play play, GameContainer gc, StateBasedGame sbg, Graphics g) {

		if (DodgeBlawk.getDataManager().asteroids.size() == 0) {

			int GenerationValue = 0;
			GenerationValue = (DodgeBlawk.i = 20 + DodgeBlawk.random.nextInt(LoadEntities.GenerationDensity) + 20);
			Generation.genAsteroid(GenerationValue);
			DodgeBlawk.player.setIncrement(DodgeBlawk.player.getIncrement() + 1);

		}

		g.drawImage(Images.Background, 0, 0);

		// Scans through the whole entites ArrayList one by one so each can
		// render
		for (Entity en : DodgeBlawk.getDataManager().entities) {
			if (en != null) {

				Entity e = en;

				// Checks to see if the entity is a player
				if (e instanceof Player) {

					Player p = DodgeBlawk.getDataManager().getPlayer(e.getId());

					DodgeBlawk.player = p;

					// Makes sure the player hasn't passed the border
					fixPlayerPosition(p, gc);

					// Checks to see if the power has waited enough time to
					// activate again
					for (Power po : p.getPowerList()) {
						if (po != null) {
							if (po.getTypeId() == 1) {
								long currentTime = System.currentTimeMillis();
								if ((currentTime - po.getLastTime()) < po.getTime() * 1000) {
								} else if (po.getLength() != po.getTicks()) {
									DodgeBlawk.getDataManager().addPowerChecker(
											new PowerChecker(po, false, currentTime));
								} else {
									DodgeBlawk.getDataManager().addPowerChecker(new PowerChecker(po, true, 0));
								}
							} else if (po.getTypeId() == 2) {
								long currentTime = System.currentTimeMillis();
								if ((currentTime - po.getLastTime()) < po.getTime() * 1000) {
								} else if (po.getLength() != po.getTicks()) {
									DodgeBlawk.getDataManager().addPowerChecker(
											new PowerChecker(po, false, currentTime));
								} else {
									DodgeBlawk.getDataManager().addPowerChecker(new PowerChecker(po, true, 0));
								}
							} else if (po.getTypeId() == 3) {
								DodgeBlawk.getDataManager().addPowerChecker(new PowerChecker(po, true, 0));
							}
						}
					}

					// Checks for powers in the player's powerlist to see if
					// they need to activate or be deleted
					for (PowerChecker pc : DodgeBlawk.getDataManager().powerchecker) {
						if (pc != null) {
							if (pc.isRemoveable()) {
								if (pc.getPower().getTypeId() == 3) {
									int amount = 0;
									if (p.getHP() + 50 >= 200) {
										amount = 200 - (int)p.getHP();
									} else {
										amount = 50;
									}
									p.setHP(p.getHP() + amount);
								}
								p.removePower(pc.getPower());
							} else {
								if (pc.getPower().getTypeId() == 1) {
									Power po = p.getPower(pc.getPower());

									int amount = 0;
									if ((int) (p.getHP() + 8) >= 193) {
										amount = 200 - (int)p.getHP();
									} else {
										amount = 8;
									}

									p.setHP(p.getHP() + amount);
									po.setTicks(po.getTicks() + 1);
									po.setLastTime(pc.getCurrentTime());
								} else if (pc.getPower().getTypeId() == 2) {
									Power po = p.getPower(pc.getPower());

									if (p.getHP() - 4 <= 0) {
										DodgeBlawk.getDataManager().addCollision(new Collision(p, null));
									}
									p.setHP(p.getHP() - 4);
									po.setTicks(po.getTicks() + 1);
									po.setLastTime(pc.getCurrentTime());
								}
							}
						}
					}

					// Clears the ArrayList after deleting the powers from the
					// player
					DodgeBlawk.getDataManager().powerchecker.clear();

					p.isCollided();
					// Renders the player's texture at the players location
					g.drawImage(p.getTexture(), p.getLocation().getX(), p.getLocation().getY());

					if (p.getTexNum() == 5 || p.getTexNum() == 4) {
						Animations.engineSmoke.draw(p.getLocation().getX(), p.getLocation().getY() + 32);
					} else if (p.getTexNum() == 2) {
						Animations.engineSmoke.draw(p.getLocation().getX() + 32, p.getLocation().getY());
					} else if (p.getTexNum() == 1 || p.getTexNum() == 3) {
						Animations.engineSmoke.draw(p.getLocation().getX(), p.getLocation().getY() - 32);
					} else if (p.getTexNum() == 0) {
						Animations.engineSmoke.draw(p.getLocation().getX() - 32, p.getLocation().getY());
					}

					// Checks to see if the entity is an Asteroid
				} else if (e instanceof Asteroid) {
					Asteroid a = DodgeBlawk.getDataManager().getAsteroid(e.getId());
					if (a.getLocation().getX() + a.getSize().getWidth() < 0
							|| a.getLocation().getY() < 0 - a.getSize().getHeight()
							|| a.getLocation().getY() > gc.getHeight() - 65) {
						DodgeBlawk.getDataManager().addCollision(new Collision(a, null));
					} else {
						a.isCollided();
						a.getLocation().setX((float) a.getLocation().getX() - a.getSMultiplier() * play.deltaTime);
						int range = 175;
						if (DodgeBlawk.player.getDifficultyAsString().equalsIgnoreCase("easy"))
							range = 100;
						else if (DodgeBlawk.player.getDifficultyAsString().equalsIgnoreCase("normal"))
							range = 175;
						else if (DodgeBlawk.player.getDifficultyAsString().equalsIgnoreCase("hard"))
							range = 250;
						if (a.getLocation().getX() > DodgeBlawk.player.getLocation().getX() - range
								&& a.getLocation().getX() < DodgeBlawk.player.getLocation().getX() + range) {
							if (DodgeBlawk.player.getLocation().getY() < a.getLocation().getY()) {
								a.getLocation().setY(
										(float) a.getLocation().getY() - a.getSMultiplier() / 2 * play.deltaTime);
							} else if (DodgeBlawk.player.getLocation().getY() > a.getLocation().getY()) {
								a.getLocation().setY(
										(float) a.getLocation().getY() + a.getSMultiplier() / 2 * play.deltaTime);
							}
							if (a.getLocation().getX() < DodgeBlawk.player.getLocation().getX()
									&& a.getLocation().getY() > DodgeBlawk.player.getLocation().getY() - range
									&& a.getLocation().getY() < DodgeBlawk.player.getLocation().getY() + range)
								a.getLocation().setX(
										a.getLocation().getX() + (a.getSMultiplier() + (a.getSMultiplier() / 2))
												* play.deltaTime);
						} else if (a.getLocation().getX() < DodgeBlawk.player.getLocation().getX()
								&& (a.getLocation().getX() < DodgeBlawk.player.getLocation().getX() + range)) {
							if (a.getLocation().getY() < gc.getHeight() / 2)
								a.getLocation()
										.setY(a.getLocation().getY() - (a.getSMultiplier() / 4) * Play.deltaTime);
							else if (a.getLocation().getY() >= gc.getHeight() / 2)
								a.getLocation()
										.setY(a.getLocation().getY() + (a.getSMultiplier() / 4) * Play.deltaTime);
						}
					}
					Animations.Asteroid.draw(a.getLocation().getX(), a.getLocation().getY());
					// Checks to see if the Entity is a bullet
				} else if (e instanceof Bullet) {
					Bullet b = DodgeBlawk.getDataManager().getBullet(e.getId());
					if (b.getDirection().toString().equals("Left")) {
						b.getLocation().setX((float) b.getLocation().getX() - b.getSMultiplier() * play.deltaTime);
					} else if (b.getDirection().toString().equals("Right")) {
						b.getLocation().setX((float) b.getLocation().getX() + b.getSMultiplier() * play.deltaTime);
					}
					if (b.getLocation().getX() + b.getSize().getWidth() > DodgeBlawk.width
							|| b.getLocation().getX() + b.getSize().getWidth() < 0)
						DodgeBlawk.getDataManager().addCollision(new Collision(b, null));

					b.isCollided();

					g.drawImage(b.getTexture(), b.getLocation().getX(), b.getLocation().getY());

					// Checks to see if the entity is a powerup
				} else if (e instanceof PowerUp) {
					PowerUp pu = DodgeBlawk.getDataManager().getPowerUp(e.getId());

					// Checks to see if the powerup should be dead
					long currentTime = System.currentTimeMillis();
					if ((currentTime - pu.getTime()) > (pu.getLast() * 1000)) {
						DodgeBlawk.getDataManager().addCollision(new Collision(pu, null));
					} else {

						if (pu.getTexNum() == 3)
							Animations.power3anim.draw(pu.getLocation().getX(), pu.getLocation().getY());
						if (pu.getTexNum() == 2)
							Animations.power2anim.draw(pu.getLocation().getX(), pu.getLocation().getY());
						if (pu.getTexNum() == 1)
							Animations.power1anim.draw(pu.getLocation().getX(), pu.getLocation().getY());
					}
				}
			}
		}
		// Renders all the Text, etc at bottom of screen
		g.setColor(Color.gray);
		g.drawImage(Images.AccessBar, 0, gc.getHeight() - 65);
		g.setColor(Color.white);
		g.fillRect((float) 5, gc.getHeight() - 15, 200 * 2.5f, 10);
		g.fillRect((float) 5, gc.getHeight() - 45, 200 / 2 * 2.5f, 10);
		g.setColor(Color.blue);
		g.fillRect((float) 5, gc.getHeight() - 45, (int)DodgeBlawk.player.getHP() / 2 * 2.5f, 10);
		g.setColor(Color.red);
		g.fillRect((float) 5, gc.getHeight() - 15, (int)DodgeBlawk.player.getHP() * 2.5f, 10);
		play.RenderFont.drawString((float) 5, gc.getHeight() - 65, "Ammunition", Color.white);
		play.RenderFont.drawString((float) 5, gc.getHeight() - 35, "Health", Color.white);
		if (DodgeBlawk.player.getScore() > DodgeBlawk.getDataManager()
				.getHighScore(DodgeBlawk.player.getDifficultyAsString()).getScore()) {
			play.RenderFont.drawString((float) 535, gc.getHeight() - 20, "Highscore: " + DodgeBlawk.player.getScore(),
					Color.white);
		} else {
			play.RenderFont.drawString((float) 535, gc.getHeight() - 20, "Highscore: "
					+ DodgeBlawk.getDataManager().getHighScore(DodgeBlawk.player.getDifficultyAsString()).getScore(),
					Color.white);
		}
		play.RenderFont.drawString((float) 535, gc.getHeight() - 60, "Wave: " + DodgeBlawk.player.getIncrement());
		play.RenderFont
				.drawString(780, gc.getHeight() - 60, "Difficulty: " + DodgeBlawk.player.getDifficultyAsString());
		play.RenderFont.drawString((float) 535, gc.getHeight() - 40, "Score: " + DodgeBlawk.player.getScore());

		// Checks to see if the collisions arraylist is empty and then scans
		// through the ArrayList one by one to do the collision methods
		if (!DodgeBlawk.getDataManager().collisions.isEmpty()) {
			for (Collision co : DodgeBlawk.getDataManager().collisions) {
				if (co != null) {
					if (co.getCollider() instanceof Player) {
						Player p = (Player) co.getCollider();
						if (co.getVictim() instanceof Asteroid) {
							int minusHealth = 20;
							if (p.getDifficultyAsString().equalsIgnoreCase("easy"))
								minusHealth = 10;
							else if (p.getDifficultyAsString().equalsIgnoreCase("medium"))
								minusHealth = 15;
							else if (p.getDifficultyAsString().equalsIgnoreCase("hard"))
								minusHealth = 20;
							if (p.getHP() - minusHealth == 0 || p.getHP() - minusHealth < 0) {
								if (p.getScore() > DodgeBlawk.getDataManager().getHighScore(p.getDifficultyAsString())
										.getScore()) {
									DodgeBlawk.getDataManager().replaceHighScore(
											new Score(p.getDifficultyAsString(), p.getScore()));
								}
								DodgeBlawk.getDataManager().removePlayer(p);
								DodgeBlawk.getDataManager().asteroids.clear();
								DodgeBlawk.getDataManager().powerups.clear();
								DodgeBlawk.getDataManager().bullets.clear();

								try {
									DodgeBlawk.getDataManager().saveArrayLists();
								} catch (IOException e) {
									e.printStackTrace();
								}
								sbg.enterState(0);
							} else {
								p.setHP(p.getHP() - minusHealth);
							}
							DodgeBlawk.s.playSound("hurt");


							DodgeBlawk.getDataManager().removeAsteroid((Asteroid) co.getVictim());
						} else if (co.getVictim() == null) {
							if (p.getScore() > DodgeBlawk.getDataManager().getHighScore(p.getDifficultyAsString())
									.getScore()) {
								DodgeBlawk.getDataManager().replaceHighScore(
										new Score(p.getDifficultyAsString(), p.getScore()));
							}
							DodgeBlawk.getDataManager().removePlayer(p);
							DodgeBlawk.getDataManager().asteroids.clear();
							DodgeBlawk.getDataManager().powerups.clear();
							DodgeBlawk.getDataManager().bullets.clear();
							try {
								DodgeBlawk.getDataManager().saveArrayLists();
							} catch (IOException e) {
								e.printStackTrace();
							}
							sbg.enterState(0);
						} else if (co.getVictim() instanceof PowerUp) {
							p.addPower(((PowerUp) co.getVictim()).getPower());
							if (((PowerUp) co.getVictim()).getPower().getTypeId() == 1
									|| ((PowerUp) co.getVictim()).getPower().getTypeId() == 3) {
								DodgeBlawk.s.playSound("powerup");
							} else if (((PowerUp) co.getVictim()).getPower().getTypeId() == 2) {
								DodgeBlawk.s.playSound("badpowerup");
							}
							DodgeBlawk.getDataManager().removePowerUp((PowerUp) co.getVictim());
						}
					} else if (co.getCollider() instanceof Bullet) {
						Bullet b = DodgeBlawk.getDataManager().getBullet(co.getCollider().getId());
						if (co.getVictim() instanceof Player && b.getOwner() != (Player) co.getVictim()) {
							Player p = (Player) co.getVictim();
							if (p.getHP() - 20 == 0 || p.getHP() - 20 < 0) {
								if (p.getScore() > DodgeBlawk.getDataManager().getHighScore(p.getDifficultyAsString())
										.getScore()) {
									DodgeBlawk.getDataManager().replaceHighScore(
											new Score(p.getDifficultyAsString(), p.getScore()));
								}
								DodgeBlawk.getDataManager().removePlayer(p);
								DodgeBlawk.getDataManager().asteroids.clear();
								DodgeBlawk.getDataManager().powerups.clear();
								DodgeBlawk.getDataManager().bullets.clear();
								try {
									DodgeBlawk.getDataManager().saveArrayLists();
								} catch (IOException e) {
									e.printStackTrace();
								}
								sbg.enterState(0);
							} else {
								p.setHP(p.getHP() - 20);
							}
							DodgeBlawk.getDataManager().removeBullet(b);
						} else if (co.getVictim() instanceof Blawk) {
							Blawk bl = (Blawk) co.getVictim();
							if (bl.getHP() - 20 == 0 || bl.getHP() - 20 < 0) {
								DodgeBlawk.getDataManager().removeBlawk(bl);
							} else {
								bl.setHP(bl.getHP() - 20);
							}
							DodgeBlawk.getDataManager().removeBullet(b);
						} else if (co.getVictim() instanceof Asteroid) {
							float scoreMultiplier = DodgeBlawk.getDataManager().asteroids.size() / 3f * 0.75f + 1f;
							DodgeBlawk.player.setScore(DodgeBlawk.player.getScore() + scoreMultiplier);
							Generation.generatePowerUp(co.getVictim().getLocation());
							DodgeBlawk.getDataManager().removeAsteroid((Asteroid) co.getVictim());
							DodgeBlawk.getDataManager().removeBullet(b);
							DodgeBlawk.s.playSound("explosion");
						} else if (co.getVictim() == null) {
							DodgeBlawk.getDataManager().removeBullet(b);
						} else if (co.getVictim() instanceof Bullet) {
							Bullet b1 = (Bullet) co.getCollider();
							if (b1.getOwner() == b.getOwner()) {
								DodgeBlawk.getDataManager().removeBullet(b1);
							} else {
								DodgeBlawk.getDataManager().removeBullet(b1);
								DodgeBlawk.getDataManager().removeBullet(b);
							}
						}
					} else if (co.getCollider() instanceof Asteroid) {
						if (co.getVictim() instanceof PowerUp) {
						} else {
							DodgeBlawk.getDataManager().removeAsteroid((Asteroid) co.getCollider());
						}
					} else if (co.getCollider() instanceof PowerUp) {
						if (co.getVictim() == null) {
							DodgeBlawk.getDataManager().removePowerUp((PowerUp) co.getCollider());
						}
					}
				}
			}

			DodgeBlawk.getDataManager().collisions.clear();
		}
		
		if (HyperSpaceMode){
			play.RenderFont.drawString(100,10,"HYPERSPACE MODE",Color.green);
		}

		// Shows the debug information
		if (Play.ShowInformation == true) {
			String X = Float.toString(DodgeBlawk.player.getLocation().getX());
			String Y = Float.toString(DodgeBlawk.player.getLocation().getY());
			play.DebugRenderFont.drawString(5, gc.getHeight() - 210, "Delta: " + play.deltaTime, Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 185, "Direction: "
					+ DodgeBlawk.player.getDirection().toString(), Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 160, "X: " + X, Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 135, "Y: " + Y, Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 85, "DodgeBlawk " + DodgeBlawk.version
					+ ", Developed by Wyndcrest.", Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 110, "FPS: " + gc.getFPS(), Color.green);
			play.DebugRenderFont.drawString(5, gc.getHeight() - 235,
					"Currently Playing : " + DodgeBlawk.getDataManager().asteroids.size() + " asteroids", Color.green);
		}
	}
}
