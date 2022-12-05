package com.verycool.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle; //Rectangle
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.*;

public class TransientBlessing extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture playerImage;

	public Rectangle player;
	private OrthographicCamera camera;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		img = new Texture("kræft_clp.jpg");
		player = new Rectangle();
		player.x = 720 / 2 - 64 / 2;
		player.y = 30;
		player.width = 64;
		player.height = 86;
		playerImage = new Texture(Gdx.files.internal("hero1.png"));

	}

	@Override
	public void render() {
		camera.update();

		ScreenUtils.clear(0, 0, 0.2f, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(playerImage, player.x, player.y);
		batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player.x = touchPos.x - 64 / 2;
			player.y = touchPos.y - 86 / 2;
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
