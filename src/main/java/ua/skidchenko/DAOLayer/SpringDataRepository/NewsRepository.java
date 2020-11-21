package ua.skidchenko.DAOLayer.SpringDataRepository;

import ua.skidchenko.Model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository <News,Long> {

}
