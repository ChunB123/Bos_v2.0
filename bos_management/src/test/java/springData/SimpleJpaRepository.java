package springData;

/**
 * @author YaphetS
 * @date 2018/9/14 下午9:07
 */
public class SimpleJpaRepository implements JpaRepository {
	@Override
	public void save() {
		System.out.println("SimpleJpaRepository");
	}
}
