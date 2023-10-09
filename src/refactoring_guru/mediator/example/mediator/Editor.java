package refactoring_guru.mediator.example.mediator;

import refactoring_guru.mediator.example.components.*;
import refactoring_guru.mediator.example.components.Component;
import refactoring_guru.mediator.example.components.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * EN: Concrete mediator. All chaotic communications between concrete components
 * have been extracted to the mediator. Now components only talk with the
 * mediator, which knows who has to handle a request.
 *
 * RU: Конкретный посредник. Все связи между конкретными компонентами переехали
 * в код посредника. Он получает извещения от своих компонентов и знает как на
 * них реагировать.
 */
public class Editor implements Mediator {
    private Title title;
    private TextBox textBox;
    private AddButton add;
    private DeleteButton del;
    private SaveButton save;
    private List list;
    private Filter filter;

    private JLabel titleLabel = new JLabel("Title:");
    private JLabel textLabel = new JLabel("Text:");
    private JLabel label = new JLabel("Add or select existing note to proceed...");
  
    /**
     * EN: Here the registration of components by the mediator.
     *
     * RU: Здесь происходит регистрация компонентов посредником.
     */
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "AddButton":
                add = (AddButton)component;
                break;
            case "DelButton":
                del = (DeleteButton)component;
                break;
            case "Filter":
                filter = (Filter)component;
                break;
            case "List":
                list = (List)component;
                this.list.addListSelectionListener(listSelectionEvent -> {
                    Note note = (Note)list.getSelectedValue();
                    if (note != null) {
                        getInfoFromList(note);
                    } else {
                        clear();
                    }
                });
                break;
            case "SaveButton":
                save = (SaveButton)component;
                break;
            case "TextBox":
                textBox = (TextBox)component;
                break;
            case "Title":
                title = (Title)component;
                break;
        }
    }

    /**
     * EN: Various methods to handle requests from particular components.
     *
     * RU: Разнообразные методы общения с компонентами.
     */
    @Override
    public void addNewNote(Note note) {
        title.setText("");
        textBox.setText("");
        list.addElement(note);
    }

    @Override
    public void deleteNote() {
        list.deleteElement();
    }

    @Override
    public void getInfoFromList(Note note) {
        title.setText(note.getName().replace('*', ' '));
        textBox.setText(note.getText());
    }

    @Override
    public void saveChanges() {
        try {
            Note note = (Note) list.getSelectedValue();
            note.setName(title.getText());
            note.setText(textBox.getText());
            list.repaint();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public void markNote() {
        try {
            Note note = list.getCurrentElement();
            String name = note.getName();
            if (!name.endsWith("*")) {
                note.setName(note.getName() + "*");
            }
            list.repaint();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public void clear() {
        title.setText("");
        textBox.setText("");
    }

    @Override
    public void sendToFilter(ListModel listModel) {
        filter.setList(listModel);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setElementsList(ListModel list) {
        this.list.setModel(list);
        this.list.repaint();
    }

    @Override
    public void hideElements(boolean flag) {
        titleLabel.setVisible(!flag);
        textLabel.setVisible(!flag);
        title.setVisible(!flag);
        textBox.setVisible(!flag);
        save.setVisible(!flag);
        label.setVisible(flag);
    }

    @Override
    public void createGUI() {
        JFrame notes = new JFrame("Notes");
        notes.setSize(960, 600);
        notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel left = new JPanel();
        left.setBorder(new LineBorder(Color.BLACK));
        left.setSize(320, 600);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter:"));
        filter.setColumns(20);
        filterPanel.add(filter);
        filterPanel.setPreferredSize(new Dimension(280, 40));
        JPanel listPanel = new JPanel();
        list.setFixedCellWidth(260);
        listPanel.setSize(320, 470);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(275, 410));
        listPanel.add(scrollPane);
        JPanel buttonPanel = new JPanel();
        add.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(add);
        del.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(del);
        buttonPanel.setLayout(new FlowLayout());
        left.add(filterPanel);
        left.add(listPanel);
        left.add(buttonPanel);
        JPanel right = new JPanel();
        right.setLayout(null);
        right.setSize(640, 600);
        right.setLocation(320, 0);
        right.setBorder(new LineBorder(Color.BLACK));
        titleLabel.setBounds(20, 4, 50, 20);
        title.setBounds(60, 5, 555, 20);
        textLabel.setBounds(20, 4, 50, 130);
        textBox.setBorder(new LineBorder(Color.DARK_GRAY));
        textBox.setBounds(20, 80, 595, 410);
        save.setBounds(270, 535, 80, 25);
        label.setFont(new Font("Verdana", Font.PLAIN, 22));
        label.setBounds(100, 240, 500, 100);
        right.add(label);
        right.add(titleLabel);
        right.add(title);
        right.add(textLabel);
        right.add(textBox);
        right.add(save);
        notes.setLayout(null);
        notes.getContentPane().add(left);
        notes.getContentPane().add(right);
        notes.setResizable(false);
        notes.setLocationRelativeTo(null);
        notes.setVisible(true);
    }
}
