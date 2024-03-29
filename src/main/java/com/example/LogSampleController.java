package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ロギング処理のサンプルを動かすためのコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/")
public class LogSampleController {

	// ロガーを取得する。（引数にはこのロガーを使用するクラスのClassオブジェクトを渡す）
	private static final Logger logger = LoggerFactory.getLogger(LogSampleController.class);

	/**
	 * ロガーに含まれる各ログレベルのメソッドを呼ぶ.
	 * 
	 * <pre>
	 * デフォルトの状態では、ERROR,WORN,INFOのみのログが
	 * コンソールに表示されます。
	 * もしDEBUG,TRACEも表示させたい場合はlogback-spring.xmlで
	 * 設定を行います。
	 * </pre>
	 * 
	 * @return ログ出力完了画面
	 */
	@RequestMapping("/loglevel")
	public String logLevel() {
		logger.error("エラーが発生しました");
		logger.warn("警告です");
		logger.info("情報です");
		logger.debug("デバッグ情報です");
		logger.trace("細かいトレース情報です");
		return "finished-output-logs";
	}

	/**
	 * システム内で例外発生を行うメソッド.<br>
	 * ここで発生した例外はGlobalExceptionHandlerが捕獲し処理をします
	 * 
	 * @throws ArithmeticException このメソッドは必ずArithmeticExceptionを発生します
	 */
	@RequestMapping("/exception")
	public String throwsException() {
		// 0で除算、非検査例外であるArithmeticExceptionが発生！
		System.out.println("例外発生前");
		System.out.println(10 / 0);
		System.out.println("例外発生後");

		return "通常はここにJSP名を書くが、ここまで処理は来ない";
	}

	/**
	 * ログイン画面に移動する.<br>
	 * 
	 * @throws ログイン画面
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
}
