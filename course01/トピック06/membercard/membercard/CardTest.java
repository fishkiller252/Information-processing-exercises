package membercard;
/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class CardTest {

    public static void main(String[] args) {
        
        // (1) レンタルカードの作成と利用テスト
        
        // Taroさん(男性25歳)が新規にレンタルカードを作成
        RentalCard card1 = new RentalCard("Taro", "male", 25);
        
        // Taroさんはまだ何も借りていないことを確認
        System.out.println("名前:" + card1.getName()
                + " 性別:" + card1.getGender()
                + " 借りている物品：" + card1.getItemName());
        
        // TaroさんがDVD1を借りる
        card1.setItemName("DVD1");
        
        // Taroさんのレンタルカードcard1の情報を出力
        System.out.println("名前:" + card1.getName()
                + " 性別:" + card1.getGender()
                + " 借りている物品：" + card1.getItemName());
        
        // (2) ポイントカードの作成と利用テスト
        
        // Hanakoさん(女性60歳)が性別未設定で新規にポイントカードを作成
        PointCard card2 = new PointCard("Hanako", "no set", 60);

        // Hanakoさんはまだポイント0であることを確認
        System.out.println("名前:" + card2.getName()
                + " ポイント:" + card2.getPoint());
        
        // Hanakoさんに10ポイントを付与（55歳以上なので獲得は2倍）
        card2.addPoint(10);
        
        // Hanakoさんの獲得ポイントを表示
        System.out.println("名前:" + card2.getName()
                + " 性別:" + card2.getGender()
                + " ポイント:" + card2.getPoint());

        // Hanakoさんが性別を女性として再申請
        card2.setGender("female");

        // 再度Hanakさんの獲得ポイントを表示して，ポイント10増加を確認
        System.out.println("名前:" + card2.getName()
                + " 性別:" + card2.getGender()
                + " ポイント:" + card2.getPoint());
    }
}