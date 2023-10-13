package mevmax.mapper;

import mevmax.entity.BlockChain;
import mevmax.entity.Protocol;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProtoBlockMapper {

    @Select("SELECT * FROM \"Protocol\"")
    List<Protocol> findAllProtocols();

    @Select("SELECT * FROM \"BlockChain\"")
    List<BlockChain> findAllBlockChains();
    @Select("SELECT SUM(tvl) FROM \"Pool\"")
    double findTotalTvl();
}
