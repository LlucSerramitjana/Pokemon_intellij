import java.util.*;

import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {

    private static ManagerImpl instance;
    private ManagerImpl(){}
    public static ManagerImpl getInstance(){
        if (instance==null){
            instance=new ManagerImpl();
        }
        return instance;
    }

    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    LinkedList<User> userList = new LinkedList<User>();
    LinkedList<Pokemon> pokemonList = new LinkedList<Pokemon>();
    LinkedList<Object> objectList = new LinkedList<Object>();
    LinkedList<Map> mapList = new LinkedList<Map>();

    @Override
    public void registerUser(User user) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                trobat=1;
            }
            i++;
        }
        if (trobat==0){this.userList.add(user);}
        else{}
    }

    @Override
    public boolean loginUser(String name, String password) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(name) && userList.get(i).getPassword().equals(password)){
                trobat=1;
            }
            i++;
        }
        if (trobat==0){return false;}
        else{return true;}
    }

    @Override
    public void addCharacter(User user, Character character) {
        int i=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                userList.get(i).setCharacter(character);
            }
            i++;
        }
    }

    @Override
    public void createObject(Object object) {
        int i=0;
        int trobat=0;
        while (i<objectList.size()){
            if (objectList.get(i).getName().equals(object.getName())){
                trobat++;
            }
            i++;
        }
        if(trobat==0){objectList.add(object);}
    }

    @Override
    public void addObject(User user, Object object) {
        int i=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                userList.get(i).getCharacter().addObject(object);
                userList.get(i).getCharacter().setMoney(userList.get(i).getCharacter().getMoney() - object.getPrice());
            }
            i++;
        }
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    @Override
    public LinkedList<User> getUsers() {
        return this.userList;
    }

    @Override
    public LinkedList<Map> getMaps() {
        return this.mapList;
    }

    @Override
    public LinkedList<User> getRanking() {
        LinkedList<User> rankinglist = this.userList;
        Collections.sort(rankinglist,new Ranking());
        return rankinglist;
    }

    @Override
    public LinkedList<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    @Override
    public LinkedList<Pokemon> getPokemonsCharacter(Character character) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getCharacter().getNickname().equals(character.getNickname())){
                trobat=1;
            }
            i++;
        }
        if(trobat==1){return userList.get(i).getCharacter().getPokemons();}
        else{return null;}
    }

    @Override
    public LinkedList<Object> getObjects() {
        return this.objectList;
    }

    @Override
    public LinkedList<Object> getObjectsPersonatge(Character character) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getCharacter().getNickname().equals(character.getNickname())){
                trobat=1;
            }
            i++;
        }
        if(trobat==1){return userList.get(i).getCharacter().getObjects();}
        else{return null;}
    }

    @Override
    public Map levelup(Character character) {
        return null;
    }
}
