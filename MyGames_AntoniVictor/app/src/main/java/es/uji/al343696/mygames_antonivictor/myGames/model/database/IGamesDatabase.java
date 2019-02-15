package es.uji.al343696.mygames_antonivictor.myGames.model.database;



import java.util.List;

import es.uji.al343696.mygames_antonivictor.myGames.model.GameData;
import es.uji.al343696.mygames_antonivictor.myGames.model.GameRelationData;

/**
 * Created by jcamen on 17/02/18.
 */

public interface IGamesDatabase {
    List<Integer> getAllGames();
    List<String> getAllPlatforms();
    List<String> getAllGenres();
    List<Integer> getGamesWithPlatform(String platformName);
    List<Integer> getGamesWithGenre(String genreName);
    GameData getGameData(int id);

    void insertGameData(GameData gameData);
    void insertPlatformData(GameRelationData platformData);
    void insertGenreData(GameRelationData genreData);

    void changeState(int idGame, GameData.MyGameState state);
    void changeComment(int idGame, String comment);

    void deleteGame(int idGame);
}
