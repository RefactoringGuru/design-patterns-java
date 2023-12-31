package refactoring_guru.state.example.states;

import refactoring_guru.state.example.ui.Player;

/**
 * EN: Concrete states provide the special implementation for all interface
 * methods.
 *
 * RU: Конкретные состояния реализуют методы абстрактного состояния по-своему.
 */
public class LockedState extends State {

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
