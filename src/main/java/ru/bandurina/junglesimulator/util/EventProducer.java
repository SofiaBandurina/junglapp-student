package ru.bandurina.junglesimulator.util;

import ru.bandurina.junglesimulator.entity.Shark;

public class EventProducer {

    public void startSimulator(Shark shark) {
        while (checkStatus(shark)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 19) {
                sleepEvent(shark);
            } else if (eventNumber >= 19 && eventNumber < 28) {
                swim(shark);
            } else if (eventNumber >= 28 && eventNumber < 37) {
                eatFish(shark);
            } else if (eventNumber >= 37 && eventNumber < 46) {
                eatSeaTurtle(shark);
            } else if (eventNumber >= 46 && eventNumber < 55) {
                eatBlowfish(shark);
            } else if (eventNumber >= 55 && eventNumber < 64) {
                attackKillerWhale(shark);
            } else if (eventNumber >= 64 && eventNumber < 73) {
                winOtherShark(shark);
            } else if (eventNumber >= 73 && eventNumber < 82) {
                loseOtherShark(shark);
            } else if (eventNumber >= 82 && eventNumber < 91) {
                eatPlankton(shark);
            } else if (eventNumber >= 91 && eventNumber < 100) {
                attackSwordfish(shark);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Акула умерла! Came over!");
    }

    private void sleepEvent(Shark shark) {
        int energy = shark.getEnergy();
        energy = energy + 7;
        if (energy > 100) {
            energy = 100;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        System.out.println("Акула поспала! +7 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void swim(Shark shark) {
        int energy = shark.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        System.out.println("Акула поплавала зря! -5 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void eatFish(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (shark.getFangs() * 4);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула полакомилась рыбкой! Текущее здоровье: " + shark.getHealth() + "! -5 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void eatSeaTurtle(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (shark.getFangs() * 6);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула съела морскую черепаху! Текущее здоровье: " + shark.getHealth() + "! -8 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void eatBlowfish(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health - (int) (shark.getFangs() * 5);
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Упс! Кажется акула съела что-то не то! Это же морской ёж! Текущее здоровье: " + shark.getHealth() + "! -5 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void attackKillerWhale(Shark shark) {
        int health = shark.getHealth();
        health = health - (int) (shark.getFangs() * 8);
        if (health < 0) {
            health = 0;
        }
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("На акулу напала косатка! Текущее здоровье: " + shark.getHealth());
    }

    private void winOtherShark(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 8;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (shark.getFangs() * 5);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула победила в схватке и отвоевала свою добычу! Текущее здоровье: " + shark.getHealth() + "! -8 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void loseOtherShark(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health - (int) (shark.getFangs() * 6);
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула проиграла в схватке! Зря потратила силы! Текущее здоровье: " + shark.getHealth() + "! -10 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void eatPlankton(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (shark.getFangs() * 3);
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула решила не тратить силы и полакомилась планктоном! Текущее здоровье: " + shark.getHealth() + "! -2 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private void attackSwordfish(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 8;
        if (energy < 0) {
            energy = 0;
        }
        health = health - (int) (shark.getFangs() * 3);
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("На акулу напала рыба-меч и ранила! Текущее здоровье: " + shark.getHealth() + "! -8 энергии! Текущая энергия: " + shark.getEnergy());
    }

    private boolean checkStatus(Shark shark) {
        System.out.println("hp: " + shark.getHealth() + " energy: " + shark.getEnergy());
        return !(shark.getHealth() <= 0);
    }

    private void checkEnergy(Shark shark) {
        if (shark.getEnergy() <= 0) {
            int health = shark.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            shark.setHealth(health);
        }
    }
}
